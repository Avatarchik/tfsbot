package sql;

import model.TFile;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Denis Danilin | denis@danilin.name
 * 01.05.2020
 * tfs ☭ sweat and blood
 */
public interface FsMapper {
    void createUserFs(@Param("owner") long owner);
    void createRoot(@Param("owner") long owner);
    void createTree(@Param("owner") long owner);

    int mkDir(
            @Param("name") String name,
            @Param("parentId") long parentId,
            @Param("indate") long indate,
            @Param("type") String type,
            @Param("owner") long owner
            );

    void mkFile(@Param("file") TFile file, @Param("owner") long owner);

    TFile getEntry(@Param("id") long id, @Param("owner") long owner);
    TFile findEntryAt(@Param("name") String name, @Param("parentId") long parentId, @Param("owner") long owner);
    List<TFile> listEntries(@Param("parentId") long dirId, @Param("owner") long id);

    void updateEntry(@Param("name") String name, @Param("parentId") long parentId, @Param("id") long id, @Param("owner") long owner);

    void dropEntry(@Param("id") long id, @Param("owner") long owner);
    void dropOrphans(@Param("id") long id, @Param("owner") long owner);

    boolean isFsTableExist(long userId);

    TFile getParentEntry(@Param("id") long id, @Param("owner") long owner);

    void dropEntryByName(@Param("name") String name, @Param("parentId") long parentId, @Param("owner") long owner);

    void dropEntries(@Param("ids") Collection<Long> ids, @Param("owner") long owner);
    void dropMultiOrphans(@Param("ids") Collection<Long> ids, @Param("owner") long owner);

    List<TFile> listTypeEntries(@Param("parentId") long dirId, @Param("type") String type, @Param("owner") long owner);

    List<TFile> getByIds(@Param("ids") Set<Long> ids, @Param("owner") long owner);

    List<TFile> getPredictors(@Param("id") long id, @Param("owner") long owner);

    int selectChildsByName(@Param("id") long id, @Param("query") String query, @Param("owner") long owner);

    void resetFound(long owner);

    List<TFile> selectFound(long owner);
}
