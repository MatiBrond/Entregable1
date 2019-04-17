public enum Criterio {

    ADDRESS_LINE("Address_line"),
    AGENCY_CODE("Agency_code"),
    DISTANCE("Distance");

    private String criterio;

    public String getCriterio(){
        return criterio;
    }

    public void setCriterio(String criterio){
        this.criterio = criterio;

    }

    Criterio(String criterio){
        this.criterio=criterio;
    }



}
