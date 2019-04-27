public class Agency implements Comparable<Agency>{

    private Address address;
    private String agency_code;
    private String correspondent_id;
    private String descripcion;
    private boolean disabled;
    private String distance;
    private String id;
    private String payment_method_id;
    private String phone;
    private String site_id;
    private boolean terminal;

    public static Criterio criterio;

    public String getAgency_code() {
        return agency_code;
    }

    public void setAgency_code(String agency_code) {
        this.agency_code = agency_code;
    }

    public static Criterio getCriterio() {
        return criterio;
    }

    public static void setCriterio(Criterio criterio) {
        Agency.criterio = criterio;
    }

    public Agency(Address address, String agency_code, String correspondent_id, String descripcion, boolean disabled, String distance, String id, String payment_method_id, String phone, String site_id, boolean terminal) {
        this.address = address;
        this.agency_code = agency_code;
        this.correspondent_id = correspondent_id;
        this.descripcion = descripcion;
        this.disabled = disabled;
        this.distance = distance;
        this.id = id;
        this.payment_method_id = payment_method_id;
        this.phone = phone;
        this.site_id = site_id;
        this.terminal = terminal;
    }


    public int compareTo(Agency o) {
        int flag = 90000;
        switch (criterio) {
            case ADDRESS_LINE:
                flag = this.address.getAddres_line().compareTo(o.address.getAddres_line());
                break;
            case AGENCY_CODE:
                flag = Integer.valueOf(this.agency_code) - Integer.valueOf(o.agency_code);
                break;

            case DISTANCE:
                flag = Integer.valueOf(this.distance) - Integer.valueOf(o.getDistance());
                break;
        }
        return flag;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAggency_code() {
        return agency_code;
    }

    public void setAggency_code(String aggency_code) {
        this.agency_code = aggency_code;
    }

    public String getCorrespondent_id() {
        return correspondent_id;
    }

    public void setCorrespondent_id(String correspondent_id) {
        this.correspondent_id = correspondent_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }





    @Override
    public String toString() {
        return "Agency{" +
                "address=" + address +
                ", aggency_code='" + agency_code + '\'' +
                ", correspondent_id='" + correspondent_id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", disabled=" + disabled +
                ", distance=" + distance +
                ", id='" + id + '\'' +
                ", payment_method_id='" + payment_method_id + '\'' +
                ", phone='" + phone + '\'' +
                ", site_id='" + site_id + '\'' +
                ", terminal=" + terminal +
                '}';
    }
}
