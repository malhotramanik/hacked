package li.doerf.hacked.remote.haveibeenpwned;

/**
 * Created by moo on 05/09/16.
 */
public class BreachedAccount {

    private String Name;
    private String Title;
    private String Domain;
    private String BreachDate;
    private String AddedDate;
    private Long PwnCount;
    private String Description;
    private String[] DataClasses;
    private Boolean isVerified;
    private Boolean isSensitive;
    private Boolean isRetired;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public String getBreachDate() {
        return BreachDate;
    }

    public void setBreachDate(String breachDate) {
        BreachDate = breachDate;
    }

    public String getAddedDate() {
        return AddedDate;
    }

    public void setAddedDate(String addedDate) {
        AddedDate = addedDate;
    }

    public Long getPwnCount() {
        return PwnCount;
    }

    public void setPwnCount(Long pwnCount) {
        PwnCount = pwnCount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String[] getDataClasses() {
        return DataClasses;
    }

    public void setDataClasses(String[] dataClasses) {
        DataClasses = dataClasses;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getSensitive() {
        return isSensitive;
    }

    public void setSensitive(Boolean sensitive) {
        isSensitive = sensitive;
    }

    public Boolean getRetired() {
        return isRetired;
    }

    public void setRetired(Boolean retired) {
        isRetired = retired;
    }
}