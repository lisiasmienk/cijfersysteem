package com.cs.cijferSysteem.dto;


public class CreateToetsDto {

    private Long docentId;
    private String datum;
    private Long vakId;
    private String tijd;
    private Long klasId;

    public Long getDocentId() {
        return docentId;
    }

    public void setDocentId(Long docentId) {
        this.docentId = docentId;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }

    public String getDatum() {
        return datum;
    }

    public Long getVakId() {
        return vakId;
    }

    public void setVakId(Long vakId) {
        this.vakId = vakId;
    }

	public Long getKlasId() {
		return klasId;
	}

	public void setKlasId(Long klasId) {
		this.klasId = klasId;
	}
}

