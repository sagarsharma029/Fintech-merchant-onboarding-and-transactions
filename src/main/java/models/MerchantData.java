package models;

public class MerchantData {
	
	private String payId;
    public String merchantType;
    public String industryType;
    public String industrySubCategory;
    public String userGroup;
    public String role;
    public String segment;
    public String businessName;
    public String email;
    public String phone;
    public String password;

    public String getPayId() {return payId;}
    public void setPayId(String payId) {this.payId = payId;}
    
    public String getMerchantType() { return merchantType; }
    public void setMerchantType(String merchantType) { this.merchantType = merchantType; }
    
    public String getIndustryType() { return industryType; }
    public void setIndustryType(String industryType) { this.industryType = industryType; }
    
    public String getIndustrySubCategory() { return industrySubCategory; }
    public void setIndustrySubCategory(String industrySubCategory) {this.industrySubCategory = industrySubCategory; }
    
    public String getUserGroup() { return userGroup; }
    public void setUserGroup(String userGroup) { this.userGroup = userGroup; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getSegment() {return segment;}
    public void setSegment(String segment) {this.segment  =segment;}
    
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}