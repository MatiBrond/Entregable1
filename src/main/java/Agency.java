public class Agency implements Comparable<Agency>{

    private Address address;
    private String aggency_code;
    private String correspondent_id;
    private String descripcion;
    private boolean disabled;
    private Double distance;
    private String id;
    private String payment_method_id;
    private String phone;
    private String site_id;
    private boolean terminal;


    public static Criterio criterio;



        public Agency(Address address, String aggency_code, String correspondent_id, String descripcion, boolean disabled, double distance, String id, String payment_method_id, String phone, String site_id, boolean terminal) {
        this.address = address;
        this.aggency_code = aggency_code;
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
                flag = this.aggency_code.compareTo(o.aggency_code);
                break;

            case DISTANCE:
                flag = Double.compare(this.distance, o.distance);
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
        return aggency_code;
    }

    public void setAggency_code(String aggency_code) {
        this.aggency_code = aggency_code;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
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
}
