package ua.audiolibrary.domain;

import java.io.Serializable;

public class Audio implements Serializable {
    private Long audioId;
    private String filePath;
    private String fileName;
    private String artist;
    private String title;

    public Audio() {

    }

    public Audio(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        Audio audio = (Audio) o;
        if (filePath != null ? !filePath.equals(audio.filePath) : audio.filePath != null) {
            return false;
        }
        if (fileName != null ? !fileName.equals(audio.fileName) : audio.fileName != null) {
            return false;
        }
        if (artist != null ? !artist.equals(audio.artist) : audio.artist != null) {
            return false;
        }
        return title != null ? title.equals(audio.title) : audio.title == null;
    }

    @Override
    public int hashCode() {
        int result = filePath != null ? filePath.hashCode() : 0;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioId=" + audioId +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}