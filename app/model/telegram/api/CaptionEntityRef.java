package model.telegram.api;

/**
 * @author Denis Danilin | denis@danilin.name
 * 26.10.2017 09:35
 * SIRBot ☭ sweat and blood
 */
public class CaptionEntityRef {
    private int offset;
    private int length;
    private String type;

    public int getOffset() {
        return offset;
    }

    public void setOffset(final int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }
}
