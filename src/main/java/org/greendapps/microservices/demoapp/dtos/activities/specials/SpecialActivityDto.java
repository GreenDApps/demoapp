package org.greendapps.microservices.demoapp.dtos.activities.specials;

public abstract class SpecialActivityDto {

    private String name;
    private Boolean isFavoriteOne;

    /**
     * @return SpecialActivityDto return the specialActivityDto
     */
    protected SpecialActivityDto() {
    }

    /**
     * @return SpecialActivityDto return the specialActivityDto
     * @param name          the name to set
     * @param isFavoriteOne the isFavoriteOne to set
     */
    protected SpecialActivityDto(String name, Boolean isFavoriteOne) {
        this.name = name;
        this.isFavoriteOne = isFavoriteOne;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Boolean return the isFavoriteOne
     */
    public Boolean isIsFavoriteOne() {
        return isFavoriteOne;
    }

    /**
     * @param isFavoriteOne the isFavoriteOne to set
     */
    public void setIsFavoriteOne(Boolean isFavoriteOne) {
        this.isFavoriteOne = isFavoriteOne;
    }

}
