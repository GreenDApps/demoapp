package org.greendapps.microservices.demoapp.dtos.activities.specials;

public class IndoorActivityDto extends SpecialActivityDto {

    private IndoorActivityEnum specialType;

    public enum IndoorActivityEnum {

        VOLUNTARY_WORK("voluntary_work") {
            @Override
            public String toString() {
                return "voluntary_work";
            }
        },

        EDUCATION("education") {
            @Override
            public String toString() {
                return "education";
            }
        },

        SPARE_TIME("spare_time") {
            @Override
            public String toString() {
                return "spare_time";
            }
        };

        private String type;

        private IndoorActivityEnum(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

    public IndoorActivityDto(String name, Boolean isFavoriteOne) {
        super(name, isFavoriteOne);
    }

    /**
     * @return IndoorActivityEnum return the specialType
     */
    public IndoorActivityEnum getSpecialType() {
        return specialType;
    }

    /**
     * @param specialType the specialType to set
     */
    public void setSpecialType(IndoorActivityEnum specialType) {
        this.specialType = specialType;
    }

    @Override
    public String toString() {
        return "{" +
                " specialType='" + getSpecialType() + "'" +
                "}";
    }

}
