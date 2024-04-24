package com.ekyc.capitaltrust.ekyc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(
        name = "AppClientDetails"
)
public class AppClientDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "AppClientId",
            nullable = false
    )
    private Integer id;
    @Column(
            name = "CustomerId"
    )
    private Integer customerId;
    @Column(
            name = "UserId"
    )
    private Integer userId;
    @Column(
            name = "BranchId"
    )
    private Integer branchId;
    @Column(
            name = "CentreId"
    )
    private Integer centreId;
    @Column(
            name = "SchemeNumber"
    )
    private Integer schemeNumber;
    @Column(
            name = "UserDeviceId",
            length = 20
    )
    private String userDeviceId;
    @Column(
            name = "ClientUID",
            length = 25
    )
    private String clientUID;
    @Column(
            name = "ClientName",
            length = 50
    )
    private String clientName;
    @Column(
            name = "ClientGender",
            length = 6
    )
    private String clientGender;
    @Column(
            name = "ClientDOB"
    )
    private Instant clientDOB;
    @Column(
            name = "ClientCareOf",
            length = 50
    )
    private String clientCareOf;
    @Column(
            name = "ClientRelation",
            length = 50
    )
    private String clientRelation;
    @Column(
            name = "ClientLandmark",
            length = 100
    )
    private String clientLandmark;
    @Column(
            name = "ClientLocality",
            length = 500
    )
    private String clientLocality;
    @Column(
            name = "ClientStreet",
            length = 500
    )
    private String clientStreet;
    @Column(
            name = "ClientTown",
            length = 500
    )
    private String clientTown;
    @Column(
            name = "ClientPostOffice",
            length = 50
    )
    private String clientPostOffice;
    @Column(
            name = "ClientDistrict",
            length = 45
    )
    private String clientDistrict;
    @Column(
            name = "ClientSubDistrict",
            length = 45
    )
    private String clientSubDistrict;
    @Column(
            name = "ClientState",
            length = 30
    )
    private String clientState;
    @Column(
            name = "ClientPinCode"
    )
    private Integer clientPinCode;
    @Column(
            name = "CoBorrowerUID",
            length = 25
    )
    private String coBorrowerUID;
    @Column(
            name = "CoBorrowerName",
            length = 50
    )
    private String coBorrowerName;
    @Column(
            name = "CoBorrowerGender",
            length = 6
    )
    private String coBorrowerGender;
    @Column(
            name = "CoBorrowerDOB"
    )
    private Instant coBorrowerDOB;
    @Column(
            name = "CoBorrowerCareOf",
            length = 50
    )
    private String coBorrowerCareOf;
    @Column(
            name = "CoBorrowerRelation",
            length = 50
    )
    private String coBorrowerRelation;
    @Column(
            name = "CoBorrowerLandmark",
            length = 80
    )
    private String coBorrowerLandmark;
    @Column(
            name = "CoBorrowerLocality",
            length = 500
    )
    private String coBorrowerLocality;
    @Column(
            name = "CoBorrowerStreet",
            length = 500
    )
    private String coBorrowerStreet;
    @Column(
            name = "CoBorrowerTown",
            length = 500
    )
    private String coBorrowerTown;
    @Column(
            name = "CoBorrowerPostOffice",
            length = 45
    )
    private String coBorrowerPostOffice;
    @Column(
            name = "CoBorrowerDistrict",
            length = 45
    )
    private String coBorrowerDistrict;
    @Column(
            name = "CoBorrowerSubDistrict",
            length = 45
    )
    private String coBorrowerSubDistrict;
    @Column(
            name = "CoBorrowerState",
            length = 30
    )
    private String coBorrowerState;
    @Column(
            name = "CoBorrowerPinCode"
    )
    private Integer coBorrowerPinCode;
    @Column(
            name = "EntryDate"
    )
    private Instant entryDate;
    @Column(
            name = "EntryTime"
    )
    private Instant entryTime;
    @Column(
            name = "ClientCareOfType",
            length = 1
    )
    private String clientCareOfType;
    @Column(
            name = "CoBorrowerCareOfType",
            length = 1
    )
    private String coBorrowerCareOfType;
    @Column(
            name = "ClientHouseNo",
            length = 70
    )
    private String clientHouseNo;
    @Column(
            name = "CoBorrowerHouseNo",
            length = 70
    )
    private String coBorrowerHouseNo;
    @Column(
            name = "CentreAllocation",
            length = 15
    )
    private String centreAllocation;
    @Column(
            name = "ClientKycType",
            length = 15
    )
    private String clientKycType;
    @Column(
            name = "CoBorrowerKycType",
            length = 25
    )
    private String coBorrowerKycType;
    @Column(
            name = "ClientMobileNo",
            length = 30
    )
    private String clientMobileNo;
    @Column(
            name = "CoBorrowerMobileNo",
            length = 30
    )
    private String coBorrowerMobileNo;
    @Column(
            name = "EnrollmentId"
    )
    private Integer enrollmentId;
    @Column(
            name = "RegularCentreId"
    )
    private Integer regularCentreId;
    @Column(
            name = "LoanId"
    )
    private Integer loanId;
    @Column(
            name = "centerDay",
            length = 10
    )
    private String centerDay;
    @Column(
            name = "centerTime"
    )
    private Instant centerTime;
    @Column(
            name = "centerDistance",
            length = 3
    )
    private String centerDistance;
    @Column(
            name = "centerSourcedById"
    )
    private Integer centerSourcedById;
    @Column(
            name = "centerGrtDoneById"
    )
    private Integer centerGrtDoneById;
    @Column(
            name = "centerSourcedByName",
            length = 30
    )
    private String centerSourcedByName;
    @Column(
            name = "centerGrtDoneByName",
            length = 30
    )
    private String centerGrtDoneByName;
    @Column(
            name = "CentreGrtDate"
    )
    private Instant centreGrtDate;
    @Column(
            name = "CustomerRenewalStatus"
    )
    private Integer customerRenewalStatus;
    @Column(
            name = "RenewalCustomerLoanId"
    )
    private Integer renewalCustomerLoanId;
    @Column(
            name = "purposeid"
    )
    private Integer purposeid;
    @Column(
            name = "purpose",
            length = 128
    )
    private String purpose;
    @Column(
            name = "purpose_category_id",
            length = 3
    )
    private String purposeCategoryId;
    @Column(
            name = "client_no_of_dependent"
    )
    private Integer clientNoOfDependent;
    @Column(
            name = "client_occupation",
            length = 12
    )
    private String clientOccupation;
    @Column(
            name = "client_caste",
            length = 12
    )
    private String clientCaste;
    @Column(
            name = "client_category",
            length = 10
    )
    private String clientCategory;
    @Column(
            name = "client_home_type",
            length = 8
    )
    private String clientHomeType;
    @Column(
            name = "client_no_of_years",
            length = 2
    )
    private String clientNoOfYears;
    @Column(
            name = "client_marital_status"
    )
    private Integer clientMaritalStatus;
    @Column(
            name = "relation",
            length = 50
    )
    private String relation;
    @Column(
            name = "coborrower_no_of_dependent"
    )
    private Integer coborrowerNoOfDependent;
    @Column(
            name = "coborrower_occupation",
            length = 10
    )
    private String coborrowerOccupation;
    @Column(
            name = "coborrower_caste",
            length = 10
    )
    private String coborrowerCaste;
    @Column(
            name = "coborrower_category",
            length = 10
    )
    private String coborrowerCategory;
    @Column(
            name = "coborrower_home_type",
            length = 8
    )
    private String coborrowerHomeType;
    @Column(
            name = "coborrower_no_of_years",
            length = 2
    )
    private String coborrowerNoOfYears;
    @Column(
            name = "coborrower_marital_status"
    )
    private Integer coborrowerMaritalStatus;
    @Column(
            name = "scheme_amount"
    )
    private Integer schemeAmount;
    @Column(
            name = "repayment"
    )
    private Integer repayment;
    @Column(
            name = "case_sl_no"
    )
    private Integer caseSlNo;
    @Column(
            name = "scan_borrower"
    )
    private Integer scanBorrower;
    @Column(
            name = "scan_coborrower"
    )
    private Integer scanCoborrower;
    @Column(
            name = "client_account_no",
            length = 30
    )
    private String clientAccountNo;
    @Column(
            name = "client_bank_ifsc",
            length = 15
    )
    private String clientBankIfsc;
    @Column(
            name = "sanction_amount"
    )
    private Integer sanctionAmount;
    @Column(
            name = "loan_creation_status"
    )
    private Integer loanCreationStatus;
    @Column(
            name = "dealer_id"
    )
    private Integer dealerId;
    @Column(
            name = "esign_status"
    )
    private Integer esignStatus;
    @Column(
            name = "ecs_status"
    )
    private Integer ecsStatus;
    @Column(
            name = "esign_document",
            length = 10
    )
    private String esignDocument;
    @Column(
            name = "centre_add_date"
    )
    private Instant centreAddDate;
    @Column(
            name = "sourcedby"
    )
    private Integer sourcedby;
    @Column(
            name = "esign_co_borr_status"
    )
    private Integer esignCoBorrStatus;
    @Column(
            name = "esign_doc_name",
            length = 12
    )
    private String esignDocName;
    @Column(
            name = "bm_decision"
    )
    private Integer bmDecision;
    @Column(
            name = "client_email_id",
            length = 80
    )
    private String clientEmailId;
    @Column(
            name = "bm_remarks",
            length = 50
    )
    private String bmRemarks;
    @Column(
            name = "CoBorrower2UID",
            length = 18
    )
    private String coBorrower2UID;
    @Column(
            name = "CoBorrower2Name",
            length = 30
    )
    private String coBorrower2Name;
    @Column(
            name = "CoBorrower2Gender",
            length = 1
    )
    private String coBorrower2Gender;
    @Column(
            name = "CoBorrower2DOB"
    )
    private Instant coBorrower2DOB;
    @Column(
            name = "CoBorrower2CareOf",
            length = 8
    )
    private String coBorrower2CareOf;
    @Column(
            name = "CoBorrower2Relation",
            length = 1
    )
    private String coBorrower2Relation;
    @Column(
            name = "CoBorrower2Landmark",
            length = 70
    )
    private String coBorrower2Landmark;
    @Column(
            name = "CoBorrower2Locality",
            length = 70
    )
    private String coBorrower2Locality;
    @Column(
            name = "CoBorrower2Street",
            length = 70
    )
    private String coBorrower2Street;
    @Column(
            name = "CoBorrower2Town",
            length = 70
    )
    private String coBorrower2Town;
    @Column(
            name = "CoBorrower2PostOffice",
            length = 50
    )
    private String coBorrower2PostOffice;
    @Column(
            name = "CoBorrower2District",
            length = 50
    )
    private String coBorrower2District;
    @Column(
            name = "CoBorrower2SubDistrict",
            length = 50
    )
    private String coBorrower2SubDistrict;
    @Column(
            name = "CoBorrower2State",
            length = 50
    )
    private String coBorrower2State;
    @Column(
            name = "CoBorrower2PinCode"
    )
    private Integer coBorrower2PinCode;
    @Column(
            name = "CoBorrower2CareOfType",
            length = 1
    )
    private String coBorrower2CareOfType;
    @Column(
            name = "CoBorrower2HouseNo",
            length = 30
    )
    private String coBorrower2HouseNo;
    @Column(
            name = "CoBorrower2KycType",
            length = 15
    )
    private String coBorrower2KycType;
    @Column(
            name = "CoBorrower2MobileNo",
            length = 12
    )
    private String coBorrower2MobileNo;
    @Column(
            name = "CoBorrower2_no_of_dependent"
    )
    private Integer coborrower2NoOfDependent;
    @Column(
            name = "CoBorrower2_occupation",
            length = 10
    )
    private String coborrower2Occupation;
    @Column(
            name = "CoBorrower2_caste",
            length = 8
    )
    private String coborrower2Caste;
    @Column(
            name = "CoBorrower2_category",
            length = 8
    )
    private String coborrower2Category;
    @Column(
            name = "CoBorrower2_home_type",
            length = 8
    )
    private String coborrower2HomeType;
    @Column(
            name = "CoBorrower2_no_of_years",
            length = 1
    )
    private String coborrower2NoOfYears;
    @Column(
            name = "CoBorrower2_marital_status"
    )
    private Integer coborrower2MaritalStatus;
    @Column(
            name = "grt_done_date"
    )
    private Instant grtDoneDate;
    @Column(
            name = "grt_approval_status"
    )
    private Integer grtApprovalStatus;
    @Column(
            name = "client_education",
            length = 20
    )
    private String clientEducation;
    @Column(
            name = "coborrower_education",
            length = 10
    )
    private String coborrowerEducation;
    @Column(
            name = "resd_dist_from_centre"
    )
    private Integer resdDistFromCentre;
    @ColumnDefault("0")
    @Column(
            name = "cfl_clients"
    )
    private Integer cflClients;
    @Column(
            name = "client_address_lat",
            length = 20
    )
    private String clientAddressLat;
    @Column(
            name = "client_address_long",
            length = 20
    )
    private String clientAddressLong;
    @Column(
            name = "client_distance_add_hometag"
    )
    private Double clientDistanceAddHometag;
    @Column(
            name = "client_distance_add_branch"
    )
    private Double clientDistanceAddBranch;
    @Column(
            name = "credit_limit"
    )
    private Integer creditLimit;
    @ColumnDefault("0")
    @Column(
            name = "is_deleted"
    )
    private Integer isDeleted;
    @Column(
            name = "deleted_by"
    )
    private Integer deletedBy;
    @Column(
            name = "delete_date"
    )
    private Instant deleteDate;
    @Column(
            name = "coborrower2_relation_with_borrower",
            length = 15
    )
    private String coborrower2RelationWithBorrower;
    @Column(
            name = "ref1_name",
            length = 50
    )
    private String ref1Name;
    @Column(
            name = "ref1_contact_no",
            length = 30
    )
    private String ref1ContactNo;
    @Column(
            name = "ref1_relation_with_borrower",
            length = 15
    )
    private String ref1RelationWithBorrower;
    @Column(
            name = "ref2_name",
            length = 30
    )
    private String ref2Name;
    @Column(
            name = "ref2_contact_no",
            length = 12
    )
    private String ref2ContactNo;
    @Column(
            name = "ref2_relation_with_borrower",
            length = 15
    )
    private String ref2RelationWithBorrower;
    @Column(
            name = "client_business_address",
            length = 50
    )
    private String clientBusinessAddress;
    @Column(
            name = "credit_limit_approval"
    )
    private Integer creditLimitApproval;
    @Column(
            name = "credit_approval_date"
    )
    private Instant creditApprovalDate;
    @Column(
            name = "credit_approved_by"
    )
    private Integer creditApprovedBy;
    @Column(
            name = "dist_bw_pv_branch",
            precision = 16,
            scale = 2
    )
    private BigDecimal distBwPvBranch;
    @Column(
            name = "cgt_date"
    )
    private Instant cgtDate;
    @Column(
            name = "cgt_approval_status"
    )
    private Integer cgtApprovalStatus;
    @Column(
            name = "cgt_date_day2"
    )
    private Instant cgtDateDay2;
    @Column(
            name = "cgt_approval_status_day2"
    )
    private Integer cgtApprovalStatusDay2;
    @Column(
            name = "equifax_score_retail",
            length = 8
    )
    private String equifaxScoreRetail;
    @Column(
            name = "equifax_score_microfinance",
            length = 8
    )
    private String equifaxScoreMicrofinance;
    @Column(
            name = "dist_bw_cgt_branch"
    )
    private Double distBwCgtBranch;
    @Column(
            name = "dist_bw_grt_branch"
    )
    private Double distBwGrtBranch;
    @Column(
            name = "borrower_mother_first_name",
            length = 30
    )
    private String borrowerMotherFirstName;
    @Column(
            name = "borrower_mother_last_name",
            length = 20
    )
    private String borrowerMotherLastName;
    @Column(
            name = "co_borrower_mother_last_name",
            length = 30
    )
    private String coBorrowerMotherLastName;
    @Column(
            name = "co_borrower_mother_first_name",
            length = 30
    )
    private String coBorrowerMotherFirstName;
    @Column(
            name = "home_ver_remarks",
            length = 400
    )
    private String homeVerRemarks;
    @Column(
            name = "appid_delete_remark",
            length = 130
    )
    private String appidDeleteRemark;
    @Column(
            name = "cfl_serial_no",
            length = 50
    )
    private String cflSerialNo;
    @ColumnDefault("1")
    @Column(
            name = "source_type"
    )
    private Integer sourceType;
    @Column(
            name = "idfc_posidex",
            length = 1024
    )
    private String idfcPosidex;
    @Column(
            name = "idfc_loan_creation",
            length = 200
    )
    private String idfcLoanCreation;
    @Column(
            name = "move_mbl_to_cml"
    )
    private Integer moveMblToCml;
    @Column(
            name = "move_mbl_to_cml_date"
    )
    private Instant moveMblToCmlDate;
    @Column(
            name = "move_by_mbl_to_cml"
    )
    private Integer moveByMblToCml;
    @Column(
            name = "idfc_loan_status_check",
            length = 200
    )
    private String idfcLoanStatusCheck;
    @Column(
            name = "lead_id"
    )
    private Integer leadId;
    @Column(
            name = "idfc_posidex_entry_date"
    )
    private Instant idfcPosidexEntryDate;
    @Column(
            name = "idfc_loan_creation_entry_date"
    )
    private Instant idfcLoanCreationEntryDate;
    @Column(
            name = "sent_to_idfc"
    )
    private Integer sentToIdfc;
    @Column(
            name = "auto_renewal_status"
    )
    private Integer autoRenewalStatus;
    @Column(
            name = "updated_address_field",
            length = 1024
    )
    private String updatedAddressField;
    @Column(
            name = "updated_by"
    )
    private Integer updatedBy;
    @Column(
            name = "updated_date"
    )
    private Instant updatedDate;
    @Column(
            name = "loan_application_no"
    )
    private Integer loanApplicationNo;
    @Column(
            name = "coborrowerupdatedaddressfield",
            length = 1024
    )
    private String coborrowerupdatedaddressfield;
    @Column(
            name = "clientpancard",
            length = 50
    )
    private String clientpancard;
    @Column(
            name = "coborrowerpancard",
            length = 50
    )
    private String coborrowerpancard;
    @Column(
            name = "center_meeting_date"
    )
    private Instant centerMeetingDate;
    @Column(
            name = "meeting_date_center"
    )
    private Integer meetingDateCenter;
    @Column(
            name = "dist_bw_center_branch"
    )
    private Double distBwCenterBranch;
    @Column(
            name = "center_meeting_id"
    )
    private Integer centerMeetingId;
    @ColumnDefault("0")
    @Column(
            name = "contact_available"
    )
    private Integer contactAvailable;
    @Column(
            name = "with_centre"
    )
    private Integer withCentre;
    @Column(
            name = "dfl_applicantclientid"
    )
    private Integer dflApplicantclientid;
    @Column(
            name = "dfl_coapplicantclientid"
    )
    private Integer dflCoapplicantclientid;
    @Column(
            name = "dfl_loan_app_status",
            length = 250
    )
    private String dflLoanAppStatus;
    @Column(
            name = "match_score"
    )
    private Integer matchScore;
    @Column(
            name = "user_approval_status"
    )
    private Integer userApprovalStatus;
    @Column(
            name = "user_approval_date"
    )
    private Instant userApprovalDate;
    @Lob
    @Column(
            name = "final_json_borrower"
    )
    private String finalJsonBorrower;
    @Lob
    @Column(
            name = "final_json_co_borrower"
    )
    private String finalJsonCoBorrower;
    @Column(
            name = "contact_available_size"
    )
    private Integer contactAvailableSize;
    @Lob
    @Column(
            name = "bureau_mobileno"
    )
    private String bureauMobileno;
    @Lob
    @Column(
            name = "bureau_Voterid"
    )
    private String bureauVoterid;
    @Column(
            name = "lb_user_id"
    )
    private Long lbUserId;
    @Column(
            name = "lb_loan_id"
    )
    private Long lbLoanId;
    @Lob
    @Column(
            name = "ocr_json"
    )
    private String ocrJson;
    @Lob
    @Column(
            name = "karza_pancard_details"
    )
    private String karzaPancardDetails;
    @Lob
    @Column(
            name = "co_borrower_ocr_response"
    )
    private String coBorrowerOcrResponse;
    @Lob
    @Column(
            name = "digitap_okyc_json"
    )
    private String digitapOkycJson;
    @Lob
    @Column(
            name = "pf_details"
    )
    private String pfDetails;
    @Column(
            name = "employee_type"
    )
    private Integer employeeType;
    @Column(
            name = "doc_deleted_status"
    )
    private Integer docDeletedStatus;
    @Column(
            name = "doc_deleted_date"
    )
    private Instant docDeletedDate;
    @Nationalized
    @Column(
            name = "doc_deleted_remark",
            length = 200
    )
    private String docDeletedRemark;
    @Lob
    @Column(
            name = "magic_udhyam_json"
    )
    private String magicUdhyamJson;
    @Column(
            name = "uan_date"
    )
    private Instant uanDate;
    @Column(
            name = "employer_name",
            length = 70
    )
    private String employerName;
    @Column(
            name = "monthly_salary",
            length = 500
    )
    private String monthlySalary;
    @Lob
    @Column(
            name = "mobile_details_json"
    )
    private String mobileDetailsJson;
    @Column(
            name = "loan_sanction_status"
    )
    private Integer loanSanctionStatus;
    @Lob
    @Column(
            name = "common_account_detection_json"
    )
    private String commonAccountDetectionJson;
    @Column(
            name = "sim_service_type",
            length = 20
    )
    private String simServiceType;
    @Lob
    @Column(
            name = "name_matching_json"
    )
    private String nameMatchingJson;
    @Column(
            name = "mobile_activation_date"
    )
    private LocalDate mobileActivationDate;
    @Column(
            name = "mobile_unbilled_balance",
            length = 20
    )
    private String mobileUnbilledBalance;
    @Column(
            name = "mobile_total_outstanding_amount",
            length = 20
    )
    private String mobileTotalOutstandingAmount;
    @Column(
            name = "is_mobile_name_match",
            length = 10
    )
    private String isMobileNameMatch;
    @Column(
            name = "is_pan_name_match",
            length = 10
    )
    private String isPanNameMatch;
    @Column(
            name = "applicable_uan_number",
            length = 50
    )
    private String applicableUanNumber;
    @Column(
            name = "applicable_date_of_joining",
            length = 50
    )
    private String applicableDateOfJoining;
    @Column(
            name = "current_organisation_name",
            length = 100
    )
    private String currentOrganisationName;
    @Column(
            name = "mobile_registered_name",
            length = 50
    )
    private String mobileRegisteredName;
    @Column(
            name = "epf_remark",
            length = 50
    )
    private String epfRemark;
    @Column(
            name = "aadhaar_approve_status"
    )
    private Integer aadhaarApproveStatus;
    @Column(
            name = "epf_approve_status"
    )
    private Integer epfApproveStatus;
    @Column(
            name = "mobile_approve_status"
    )
    private Integer mobileApproveStatus;
    @Column(
            name = "pan_card_approve_status"
    )
    private Integer panCardApproveStatus;
    @Column(
            name = "client_form_date"
    )
    private Instant clientFormDate;
    @Column(
            name = "epf_verification_date"
    )
    private Instant epfVerificationDate;
    @Column(
            name = "mobile_verification_date"
    )
    private Instant mobileVerificationDate;
    @Column(
            name = "pan_card_verification_date"
    )
    private Instant panCardVerificationDate;
    @Column(
            name = "aadhaar_verification_date"
    )
    private Instant aadhaarVerificationDate;
    @Column(
            name = "loan_sanction_date"
    )
    private Instant loanSanctionDate;
    @Column(
            name = "mobile_overdue_days",
            length = 50
    )
    private String mobileOverdueDays;
    @Column(
            name = "equifax_job_status"
    )
    private Integer equifaxJobStatus;
    @Column(
            name = "center_approval_status"
    )
    private Integer centerApprovalStatus;
    @Column(
            name = "center_approval_by"
    )
    private Integer centerApprovalBy;
    @Column(
            name = "center_approval_date"
    )
    private Instant centerApprovalDate;
    @Column(
            name = "center_approval_meeting_date",
            length = 100
    )
    private String centerApprovalMeetingDate;
    @Column(
            name = "digit_sms_status"
    )
    private Integer digitSmsStatus;
    @Column(
            name = "digit_sms_date"
    )
    private Instant digitSmsDate;
    @Lob
    @Column(
            name = "borrower_adress_line1"
    )
    private String borrowerAdressLine1;
    @Lob
    @Column(
            name = "coborrower_adress_line2"
    )
    private String coborrowerAdressLine2;
    @Lob
    @Column(
            name = "coborrower_adress_line1"
    )
    private String coborrowerAdressLine1;
    @Lob
    @Column(
            name = "borrower_adress_line2"
    )
    private String borrowerAdressLine2;
    @Lob
    @Column(
            name = "borrower_address"
    )
    private String borrowerAddress;
    @Lob
    @Column(
            name = "coborrower_address"
    )
    private String coborrowerAddress;
    @Lob
    @Column(
            name = "aadhaar_name"
    )
    private String aadhaarName;
    @ColumnDefault("0")
    @Column(
            name = "mask_aadhaar_borrower_count"
    )
    private Integer maskAadhaarBorrowerCount;
    @Column(
            name = "mask_aadhaar_coborrower_count"
    )
    private Integer maskAadhaarCoborrowerCount;
    @Lob
    @Column(
            name = "masking_response_borrower"
    )
    private String maskingResponseBorrower;
    @Lob
    @Column(
            name = "masking_response_coborrower"
    )
    private String maskingResponseCoborrower;
    @Lob
    @Column(
            name = "application_status"
    )
    private String applicationStatus;
    @Lob
    @Column(
            name = "api_status"
    )
    private String apiStatus;
    @Column(
            name = "CoBorrowerVoterId",
            length = 150
    )
    private String coBorrowerVoterId;
    @Column(
            name = "docs_count"
    )
    private Integer docsCount;
    @Column(
            name = "hv_income"
    )
    private Double hvIncome;
    @Column(
            name = "further_docs_status"
    )
    private Integer furtherDocsStatus;
    @Column(
            name = "borrower_pancard_doc_status"
    )
    private Integer borrowerPancardDocStatus;
    @Column(
            name = "borrower_voterid_doc_status"
    )
    private Integer borrowerVoteridDocStatus;
    @Column(
            name = "coborrower_pancard_doc_status"
    )
    private Integer coborrowerPancardDocStatus;
    @Column(
            name = "coborrower_voterid_doc_status"
    )
    private Integer coborrowerVoteridDocStatus;
    @Column(
            name = "credit_line_id"
    )
    private Integer creditLineId;
    @Column(
            name = "account_status",
            length = 100
    )
    private String accountStatus;
    @Column(
            name = "block_code",
            length = 100
    )
    private String blockCode;
    @Column(
            name = "block_reason",
            length = 100
    )
    private String blockReason;
    @Column(
            name = "lender",
            length = 100
    )
    private String lender;
    @Column(
            name = "is_borrower_docs_further"
    )
    private Integer isBorrowerDocsFurther;
    @Column(
            name = "is_coborrower_docs_further"
    )
    private Integer isCoborrowerDocsFurther;
    @Lob
    @Column(
            name = "coborrower_pancard_details"
    )
    private String coborrowerPancardDetails;
    @Column(
            name = "borrower_pancard_name",
            length = 100
    )
    private String borrowerPancardName;
    @Column(
            name = "coborrower_pancard_name",
            length = 100
    )
    private String coborrowerPancardName;
    @Column(
            name = "coborrower_pancard_status",
            length = 100
    )
    private String coborrowerPancardStatus;
    @Column(
            name = "upi_payment_id",
            length = 40
    )
    private String upiPaymentId;
    @Lob
    @Column(
            name = "upi_payment_reason"
    )
    private String upiPaymentReason;
    @Column(
            name = "stage_starting_process_time"
    )
    private Instant stageStartingProcessTime;
    @Column(
            name = "stage_ending_process_time"
    )
    private Instant stageEndingProcessTime;
    @Column(
            name = "connect_current_process_stage",
            length = 100
    )
    private String connectCurrentProcessStage;
    @Column(
            name = "coborrower_mobile_verify"
    )
    private Integer coborrowerMobileVerify;
    @Column(
            name = "website",
            length = 1000
    )
    private String website;
    @Column(
            name = "locationdegree",
            length = 100
    )
    private String locationdegree;
    @Column(
            name = "locationdate",
            length = 100
    )
    private String locationdate;
    @Lob
    @Column(
            name = "borrower_aadhaar_pan_link_response"
    )
    private String borrowerAadhaarPanLinkResponse;
    @Lob
    @Column(
            name = "coborrower_aadhaar_pan_link_response"
    )
    private String coborrowerAadhaarPanLinkResponse;
    @Column(
            name = "payer_name",
            length = 100
    )
    private String payerName;

    public AppClientDetails() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBranchId() {
        return this.branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getCentreId() {
        return this.centreId;
    }

    public void setCentreId(Integer centreId) {
        this.centreId = centreId;
    }

    public Integer getSchemeNumber() {
        return this.schemeNumber;
    }

    public void setSchemeNumber(Integer schemeNumber) {
        this.schemeNumber = schemeNumber;
    }

    public String getUserDeviceId() {
        return this.userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }

    public String getClientUID() {
        return this.clientUID;
    }

    public void setClientUID(String clientUID) {
        this.clientUID = clientUID;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientGender() {
        return this.clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public Instant getClientDOB() {
        return this.clientDOB;
    }

    public void setClientDOB(Instant clientDOB) {
        this.clientDOB = clientDOB;
    }

    public String getClientCareOf() {
        return this.clientCareOf;
    }

    public void setClientCareOf(String clientCareOf) {
        this.clientCareOf = clientCareOf;
    }

    public String getClientRelation() {
        return this.clientRelation;
    }

    public void setClientRelation(String clientRelation) {
        this.clientRelation = clientRelation;
    }

    public String getClientLandmark() {
        return this.clientLandmark;
    }

    public void setClientLandmark(String clientLandmark) {
        this.clientLandmark = clientLandmark;
    }

    public String getClientLocality() {
        return this.clientLocality;
    }

    public void setClientLocality(String clientLocality) {
        this.clientLocality = clientLocality;
    }

    public String getClientStreet() {
        return this.clientStreet;
    }

    public void setClientStreet(String clientStreet) {
        this.clientStreet = clientStreet;
    }

    public String getClientTown() {
        return this.clientTown;
    }

    public void setClientTown(String clientTown) {
        this.clientTown = clientTown;
    }

    public String getClientPostOffice() {
        return this.clientPostOffice;
    }

    public void setClientPostOffice(String clientPostOffice) {
        this.clientPostOffice = clientPostOffice;
    }

    public String getClientDistrict() {
        return this.clientDistrict;
    }

    public void setClientDistrict(String clientDistrict) {
        this.clientDistrict = clientDistrict;
    }

    public String getClientSubDistrict() {
        return this.clientSubDistrict;
    }

    public void setClientSubDistrict(String clientSubDistrict) {
        this.clientSubDistrict = clientSubDistrict;
    }

    public String getClientState() {
        return this.clientState;
    }

    public void setClientState(String clientState) {
        this.clientState = clientState;
    }

    public Integer getClientPinCode() {
        return this.clientPinCode;
    }

    public void setClientPinCode(Integer clientPinCode) {
        this.clientPinCode = clientPinCode;
    }

    public String getCoBorrowerUID() {
        return this.coBorrowerUID;
    }

    public void setCoBorrowerUID(String coBorrowerUID) {
        this.coBorrowerUID = coBorrowerUID;
    }

    public String getCoBorrowerName() {
        return this.coBorrowerName;
    }

    public void setCoBorrowerName(String coBorrowerName) {
        this.coBorrowerName = coBorrowerName;
    }

    public String getCoBorrowerGender() {
        return this.coBorrowerGender;
    }

    public void setCoBorrowerGender(String coBorrowerGender) {
        this.coBorrowerGender = coBorrowerGender;
    }

    public Instant getCoBorrowerDOB() {
        return this.coBorrowerDOB;
    }

    public void setCoBorrowerDOB(Instant coBorrowerDOB) {
        this.coBorrowerDOB = coBorrowerDOB;
    }

    public String getCoBorrowerCareOf() {
        return this.coBorrowerCareOf;
    }

    public void setCoBorrowerCareOf(String coBorrowerCareOf) {
        this.coBorrowerCareOf = coBorrowerCareOf;
    }

    public String getCoBorrowerRelation() {
        return this.coBorrowerRelation;
    }

    public void setCoBorrowerRelation(String coBorrowerRelation) {
        this.coBorrowerRelation = coBorrowerRelation;
    }

    public String getCoBorrowerLandmark() {
        return this.coBorrowerLandmark;
    }

    public void setCoBorrowerLandmark(String coBorrowerLandmark) {
        this.coBorrowerLandmark = coBorrowerLandmark;
    }

    public String getCoBorrowerLocality() {
        return this.coBorrowerLocality;
    }

    public void setCoBorrowerLocality(String coBorrowerLocality) {
        this.coBorrowerLocality = coBorrowerLocality;
    }

    public String getCoBorrowerStreet() {
        return this.coBorrowerStreet;
    }

    public void setCoBorrowerStreet(String coBorrowerStreet) {
        this.coBorrowerStreet = coBorrowerStreet;
    }

    public String getCoBorrowerTown() {
        return this.coBorrowerTown;
    }

    public void setCoBorrowerTown(String coBorrowerTown) {
        this.coBorrowerTown = coBorrowerTown;
    }

    public String getCoBorrowerPostOffice() {
        return this.coBorrowerPostOffice;
    }

    public void setCoBorrowerPostOffice(String coBorrowerPostOffice) {
        this.coBorrowerPostOffice = coBorrowerPostOffice;
    }

    public String getCoBorrowerDistrict() {
        return this.coBorrowerDistrict;
    }

    public void setCoBorrowerDistrict(String coBorrowerDistrict) {
        this.coBorrowerDistrict = coBorrowerDistrict;
    }

    public String getCoBorrowerSubDistrict() {
        return this.coBorrowerSubDistrict;
    }

    public void setCoBorrowerSubDistrict(String coBorrowerSubDistrict) {
        this.coBorrowerSubDistrict = coBorrowerSubDistrict;
    }

    public String getCoBorrowerState() {
        return this.coBorrowerState;
    }

    public void setCoBorrowerState(String coBorrowerState) {
        this.coBorrowerState = coBorrowerState;
    }

    public Integer getCoBorrowerPinCode() {
        return this.coBorrowerPinCode;
    }

    public void setCoBorrowerPinCode(Integer coBorrowerPinCode) {
        this.coBorrowerPinCode = coBorrowerPinCode;
    }

    public Instant getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Instant entryDate) {
        this.entryDate = entryDate;
    }

    public Instant getEntryTime() {
        return this.entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public String getClientCareOfType() {
        return this.clientCareOfType;
    }

    public void setClientCareOfType(String clientCareOfType) {
        this.clientCareOfType = clientCareOfType;
    }

    public String getCoBorrowerCareOfType() {
        return this.coBorrowerCareOfType;
    }

    public void setCoBorrowerCareOfType(String coBorrowerCareOfType) {
        this.coBorrowerCareOfType = coBorrowerCareOfType;
    }

    public String getClientHouseNo() {
        return this.clientHouseNo;
    }

    public void setClientHouseNo(String clientHouseNo) {
        this.clientHouseNo = clientHouseNo;
    }

    public String getCoBorrowerHouseNo() {
        return this.coBorrowerHouseNo;
    }

    public void setCoBorrowerHouseNo(String coBorrowerHouseNo) {
        this.coBorrowerHouseNo = coBorrowerHouseNo;
    }

    public String getCentreAllocation() {
        return this.centreAllocation;
    }

    public void setCentreAllocation(String centreAllocation) {
        this.centreAllocation = centreAllocation;
    }

    public String getClientKycType() {
        return this.clientKycType;
    }

    public void setClientKycType(String clientKycType) {
        this.clientKycType = clientKycType;
    }

    public String getCoBorrowerKycType() {
        return this.coBorrowerKycType;
    }

    public void setCoBorrowerKycType(String coBorrowerKycType) {
        this.coBorrowerKycType = coBorrowerKycType;
    }

    public String getClientMobileNo() {
        return this.clientMobileNo;
    }

    public void setClientMobileNo(String clientMobileNo) {
        this.clientMobileNo = clientMobileNo;
    }

    public String getCoBorrowerMobileNo() {
        return this.coBorrowerMobileNo;
    }

    public void setCoBorrowerMobileNo(String coBorrowerMobileNo) {
        this.coBorrowerMobileNo = coBorrowerMobileNo;
    }

    public Integer getEnrollmentId() {
        return this.enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Integer getRegularCentreId() {
        return this.regularCentreId;
    }

    public void setRegularCentreId(Integer regularCentreId) {
        this.regularCentreId = regularCentreId;
    }

    public Integer getLoanId() {
        return this.loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getCenterDay() {
        return this.centerDay;
    }

    public void setCenterDay(String centerDay) {
        this.centerDay = centerDay;
    }

    public Instant getCenterTime() {
        return this.centerTime;
    }

    public void setCenterTime(Instant centerTime) {
        this.centerTime = centerTime;
    }

    public String getCenterDistance() {
        return this.centerDistance;
    }

    public void setCenterDistance(String centerDistance) {
        this.centerDistance = centerDistance;
    }

    public Integer getCenterSourcedById() {
        return this.centerSourcedById;
    }

    public void setCenterSourcedById(Integer centerSourcedById) {
        this.centerSourcedById = centerSourcedById;
    }

    public Integer getCenterGrtDoneById() {
        return this.centerGrtDoneById;
    }

    public void setCenterGrtDoneById(Integer centerGrtDoneById) {
        this.centerGrtDoneById = centerGrtDoneById;
    }

    public String getCenterSourcedByName() {
        return this.centerSourcedByName;
    }

    public void setCenterSourcedByName(String centerSourcedByName) {
        this.centerSourcedByName = centerSourcedByName;
    }

    public String getCenterGrtDoneByName() {
        return this.centerGrtDoneByName;
    }

    public void setCenterGrtDoneByName(String centerGrtDoneByName) {
        this.centerGrtDoneByName = centerGrtDoneByName;
    }

    public Instant getCentreGrtDate() {
        return this.centreGrtDate;
    }

    public void setCentreGrtDate(Instant centreGrtDate) {
        this.centreGrtDate = centreGrtDate;
    }

    public Integer getCustomerRenewalStatus() {
        return this.customerRenewalStatus;
    }

    public void setCustomerRenewalStatus(Integer customerRenewalStatus) {
        this.customerRenewalStatus = customerRenewalStatus;
    }

    public Integer getRenewalCustomerLoanId() {
        return this.renewalCustomerLoanId;
    }

    public void setRenewalCustomerLoanId(Integer renewalCustomerLoanId) {
        this.renewalCustomerLoanId = renewalCustomerLoanId;
    }

    public Integer getPurposeid() {
        return this.purposeid;
    }

    public void setPurposeid(Integer purposeid) {
        this.purposeid = purposeid;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurposeCategoryId() {
        return this.purposeCategoryId;
    }

    public void setPurposeCategoryId(String purposeCategoryId) {
        this.purposeCategoryId = purposeCategoryId;
    }

    public Integer getClientNoOfDependent() {
        return this.clientNoOfDependent;
    }

    public void setClientNoOfDependent(Integer clientNoOfDependent) {
        this.clientNoOfDependent = clientNoOfDependent;
    }

    public String getClientOccupation() {
        return this.clientOccupation;
    }

    public void setClientOccupation(String clientOccupation) {
        this.clientOccupation = clientOccupation;
    }

    public String getClientCaste() {
        return this.clientCaste;
    }

    public void setClientCaste(String clientCaste) {
        this.clientCaste = clientCaste;
    }

    public String getClientCategory() {
        return this.clientCategory;
    }

    public void setClientCategory(String clientCategory) {
        this.clientCategory = clientCategory;
    }

    public String getClientHomeType() {
        return this.clientHomeType;
    }

    public void setClientHomeType(String clientHomeType) {
        this.clientHomeType = clientHomeType;
    }

    public String getClientNoOfYears() {
        return this.clientNoOfYears;
    }

    public void setClientNoOfYears(String clientNoOfYears) {
        this.clientNoOfYears = clientNoOfYears;
    }

    public Integer getClientMaritalStatus() {
        return this.clientMaritalStatus;
    }

    public void setClientMaritalStatus(Integer clientMaritalStatus) {
        this.clientMaritalStatus = clientMaritalStatus;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getCoborrowerNoOfDependent() {
        return this.coborrowerNoOfDependent;
    }

    public void setCoborrowerNoOfDependent(Integer coborrowerNoOfDependent) {
        this.coborrowerNoOfDependent = coborrowerNoOfDependent;
    }

    public String getCoborrowerOccupation() {
        return this.coborrowerOccupation;
    }

    public void setCoborrowerOccupation(String coborrowerOccupation) {
        this.coborrowerOccupation = coborrowerOccupation;
    }

    public String getCoborrowerCaste() {
        return this.coborrowerCaste;
    }

    public void setCoborrowerCaste(String coborrowerCaste) {
        this.coborrowerCaste = coborrowerCaste;
    }

    public String getCoborrowerCategory() {
        return this.coborrowerCategory;
    }

    public void setCoborrowerCategory(String coborrowerCategory) {
        this.coborrowerCategory = coborrowerCategory;
    }

    public String getCoborrowerHomeType() {
        return this.coborrowerHomeType;
    }

    public void setCoborrowerHomeType(String coborrowerHomeType) {
        this.coborrowerHomeType = coborrowerHomeType;
    }

    public String getCoborrowerNoOfYears() {
        return this.coborrowerNoOfYears;
    }

    public void setCoborrowerNoOfYears(String coborrowerNoOfYears) {
        this.coborrowerNoOfYears = coborrowerNoOfYears;
    }

    public Integer getCoborrowerMaritalStatus() {
        return this.coborrowerMaritalStatus;
    }

    public void setCoborrowerMaritalStatus(Integer coborrowerMaritalStatus) {
        this.coborrowerMaritalStatus = coborrowerMaritalStatus;
    }

    public Integer getSchemeAmount() {
        return this.schemeAmount;
    }

    public void setSchemeAmount(Integer schemeAmount) {
        this.schemeAmount = schemeAmount;
    }

    public Integer getRepayment() {
        return this.repayment;
    }

    public void setRepayment(Integer repayment) {
        this.repayment = repayment;
    }

    public Integer getCaseSlNo() {
        return this.caseSlNo;
    }

    public void setCaseSlNo(Integer caseSlNo) {
        this.caseSlNo = caseSlNo;
    }

    public Integer getScanBorrower() {
        return this.scanBorrower;
    }

    public void setScanBorrower(Integer scanBorrower) {
        this.scanBorrower = scanBorrower;
    }

    public Integer getScanCoborrower() {
        return this.scanCoborrower;
    }

    public void setScanCoborrower(Integer scanCoborrower) {
        this.scanCoborrower = scanCoborrower;
    }

    public String getClientAccountNo() {
        return this.clientAccountNo;
    }

    public void setClientAccountNo(String clientAccountNo) {
        this.clientAccountNo = clientAccountNo;
    }

    public String getClientBankIfsc() {
        return this.clientBankIfsc;
    }

    public void setClientBankIfsc(String clientBankIfsc) {
        this.clientBankIfsc = clientBankIfsc;
    }

    public Integer getSanctionAmount() {
        return this.sanctionAmount;
    }

    public void setSanctionAmount(Integer sanctionAmount) {
        this.sanctionAmount = sanctionAmount;
    }

    public Integer getLoanCreationStatus() {
        return this.loanCreationStatus;
    }

    public void setLoanCreationStatus(Integer loanCreationStatus) {
        this.loanCreationStatus = loanCreationStatus;
    }

    public Integer getDealerId() {
        return this.dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getEsignStatus() {
        return this.esignStatus;
    }

    public void setEsignStatus(Integer esignStatus) {
        this.esignStatus = esignStatus;
    }

    public Integer getEcsStatus() {
        return this.ecsStatus;
    }

    public void setEcsStatus(Integer ecsStatus) {
        this.ecsStatus = ecsStatus;
    }

    public String getEsignDocument() {
        return this.esignDocument;
    }

    public void setEsignDocument(String esignDocument) {
        this.esignDocument = esignDocument;
    }

    public Instant getCentreAddDate() {
        return this.centreAddDate;
    }

    public void setCentreAddDate(Instant centreAddDate) {
        this.centreAddDate = centreAddDate;
    }

    public Integer getSourcedby() {
        return this.sourcedby;
    }

    public void setSourcedby(Integer sourcedby) {
        this.sourcedby = sourcedby;
    }

    public Integer getEsignCoBorrStatus() {
        return this.esignCoBorrStatus;
    }

    public void setEsignCoBorrStatus(Integer esignCoBorrStatus) {
        this.esignCoBorrStatus = esignCoBorrStatus;
    }

    public String getEsignDocName() {
        return this.esignDocName;
    }

    public void setEsignDocName(String esignDocName) {
        this.esignDocName = esignDocName;
    }

    public Integer getBmDecision() {
        return this.bmDecision;
    }

    public void setBmDecision(Integer bmDecision) {
        this.bmDecision = bmDecision;
    }

    public String getClientEmailId() {
        return this.clientEmailId;
    }

    public void setClientEmailId(String clientEmailId) {
        this.clientEmailId = clientEmailId;
    }

    public String getBmRemarks() {
        return this.bmRemarks;
    }

    public void setBmRemarks(String bmRemarks) {
        this.bmRemarks = bmRemarks;
    }

    public String getCoBorrower2UID() {
        return this.coBorrower2UID;
    }

    public void setCoBorrower2UID(String coBorrower2UID) {
        this.coBorrower2UID = coBorrower2UID;
    }

    public String getCoBorrower2Name() {
        return this.coBorrower2Name;
    }

    public void setCoBorrower2Name(String coBorrower2Name) {
        this.coBorrower2Name = coBorrower2Name;
    }

    public String getCoBorrower2Gender() {
        return this.coBorrower2Gender;
    }

    public void setCoBorrower2Gender(String coBorrower2Gender) {
        this.coBorrower2Gender = coBorrower2Gender;
    }

    public Instant getCoBorrower2DOB() {
        return this.coBorrower2DOB;
    }

    public void setCoBorrower2DOB(Instant coBorrower2DOB) {
        this.coBorrower2DOB = coBorrower2DOB;
    }

    public String getCoBorrower2CareOf() {
        return this.coBorrower2CareOf;
    }

    public void setCoBorrower2CareOf(String coBorrower2CareOf) {
        this.coBorrower2CareOf = coBorrower2CareOf;
    }

    public String getCoBorrower2Relation() {
        return this.coBorrower2Relation;
    }

    public void setCoBorrower2Relation(String coBorrower2Relation) {
        this.coBorrower2Relation = coBorrower2Relation;
    }

    public String getCoBorrower2Landmark() {
        return this.coBorrower2Landmark;
    }

    public void setCoBorrower2Landmark(String coBorrower2Landmark) {
        this.coBorrower2Landmark = coBorrower2Landmark;
    }

    public String getCoBorrower2Locality() {
        return this.coBorrower2Locality;
    }

    public void setCoBorrower2Locality(String coBorrower2Locality) {
        this.coBorrower2Locality = coBorrower2Locality;
    }

    public String getCoBorrower2Street() {
        return this.coBorrower2Street;
    }

    public void setCoBorrower2Street(String coBorrower2Street) {
        this.coBorrower2Street = coBorrower2Street;
    }

    public String getCoBorrower2Town() {
        return this.coBorrower2Town;
    }

    public void setCoBorrower2Town(String coBorrower2Town) {
        this.coBorrower2Town = coBorrower2Town;
    }

    public String getCoBorrower2PostOffice() {
        return this.coBorrower2PostOffice;
    }

    public void setCoBorrower2PostOffice(String coBorrower2PostOffice) {
        this.coBorrower2PostOffice = coBorrower2PostOffice;
    }

    public String getCoBorrower2District() {
        return this.coBorrower2District;
    }

    public void setCoBorrower2District(String coBorrower2District) {
        this.coBorrower2District = coBorrower2District;
    }

    public String getCoBorrower2SubDistrict() {
        return this.coBorrower2SubDistrict;
    }

    public void setCoBorrower2SubDistrict(String coBorrower2SubDistrict) {
        this.coBorrower2SubDistrict = coBorrower2SubDistrict;
    }

    public String getCoBorrower2State() {
        return this.coBorrower2State;
    }

    public void setCoBorrower2State(String coBorrower2State) {
        this.coBorrower2State = coBorrower2State;
    }

    public Integer getCoBorrower2PinCode() {
        return this.coBorrower2PinCode;
    }

    public void setCoBorrower2PinCode(Integer coBorrower2PinCode) {
        this.coBorrower2PinCode = coBorrower2PinCode;
    }

    public String getCoBorrower2CareOfType() {
        return this.coBorrower2CareOfType;
    }

    public void setCoBorrower2CareOfType(String coBorrower2CareOfType) {
        this.coBorrower2CareOfType = coBorrower2CareOfType;
    }

    public String getCoBorrower2HouseNo() {
        return this.coBorrower2HouseNo;
    }

    public void setCoBorrower2HouseNo(String coBorrower2HouseNo) {
        this.coBorrower2HouseNo = coBorrower2HouseNo;
    }

    public String getCoBorrower2KycType() {
        return this.coBorrower2KycType;
    }

    public void setCoBorrower2KycType(String coBorrower2KycType) {
        this.coBorrower2KycType = coBorrower2KycType;
    }

    public String getCoBorrower2MobileNo() {
        return this.coBorrower2MobileNo;
    }

    public void setCoBorrower2MobileNo(String coBorrower2MobileNo) {
        this.coBorrower2MobileNo = coBorrower2MobileNo;
    }

    public Integer getCoborrower2NoOfDependent() {
        return this.coborrower2NoOfDependent;
    }

    public void setCoborrower2NoOfDependent(Integer coborrower2NoOfDependent) {
        this.coborrower2NoOfDependent = coborrower2NoOfDependent;
    }

    public String getCoborrower2Occupation() {
        return this.coborrower2Occupation;
    }

    public void setCoborrower2Occupation(String coborrower2Occupation) {
        this.coborrower2Occupation = coborrower2Occupation;
    }

    public String getCoborrower2Caste() {
        return this.coborrower2Caste;
    }

    public void setCoborrower2Caste(String coborrower2Caste) {
        this.coborrower2Caste = coborrower2Caste;
    }

    public String getCoborrower2Category() {
        return this.coborrower2Category;
    }

    public void setCoborrower2Category(String coborrower2Category) {
        this.coborrower2Category = coborrower2Category;
    }

    public String getCoborrower2HomeType() {
        return this.coborrower2HomeType;
    }

    public void setCoborrower2HomeType(String coborrower2HomeType) {
        this.coborrower2HomeType = coborrower2HomeType;
    }

    public String getCoborrower2NoOfYears() {
        return this.coborrower2NoOfYears;
    }

    public void setCoborrower2NoOfYears(String coborrower2NoOfYears) {
        this.coborrower2NoOfYears = coborrower2NoOfYears;
    }

    public Integer getCoborrower2MaritalStatus() {
        return this.coborrower2MaritalStatus;
    }

    public void setCoborrower2MaritalStatus(Integer coborrower2MaritalStatus) {
        this.coborrower2MaritalStatus = coborrower2MaritalStatus;
    }

    public Instant getGrtDoneDate() {
        return this.grtDoneDate;
    }

    public void setGrtDoneDate(Instant grtDoneDate) {
        this.grtDoneDate = grtDoneDate;
    }

    public Integer getGrtApprovalStatus() {
        return this.grtApprovalStatus;
    }

    public void setGrtApprovalStatus(Integer grtApprovalStatus) {
        this.grtApprovalStatus = grtApprovalStatus;
    }

    public String getClientEducation() {
        return this.clientEducation;
    }

    public void setClientEducation(String clientEducation) {
        this.clientEducation = clientEducation;
    }

    public String getCoborrowerEducation() {
        return this.coborrowerEducation;
    }

    public void setCoborrowerEducation(String coborrowerEducation) {
        this.coborrowerEducation = coborrowerEducation;
    }

    public Integer getResdDistFromCentre() {
        return this.resdDistFromCentre;
    }

    public void setResdDistFromCentre(Integer resdDistFromCentre) {
        this.resdDistFromCentre = resdDistFromCentre;
    }

    public Integer getCflClients() {
        return this.cflClients;
    }

    public void setCflClients(Integer cflClients) {
        this.cflClients = cflClients;
    }

    public String getClientAddressLat() {
        return this.clientAddressLat;
    }

    public void setClientAddressLat(String clientAddressLat) {
        this.clientAddressLat = clientAddressLat;
    }

    public String getClientAddressLong() {
        return this.clientAddressLong;
    }

    public void setClientAddressLong(String clientAddressLong) {
        this.clientAddressLong = clientAddressLong;
    }

    public Double getClientDistanceAddHometag() {
        return this.clientDistanceAddHometag;
    }

    public void setClientDistanceAddHometag(Double clientDistanceAddHometag) {
        this.clientDistanceAddHometag = clientDistanceAddHometag;
    }

    public Double getClientDistanceAddBranch() {
        return this.clientDistanceAddBranch;
    }

    public void setClientDistanceAddBranch(Double clientDistanceAddBranch) {
        this.clientDistanceAddBranch = clientDistanceAddBranch;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Instant getDeleteDate() {
        return this.deleteDate;
    }

    public void setDeleteDate(Instant deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getCoborrower2RelationWithBorrower() {
        return this.coborrower2RelationWithBorrower;
    }

    public void setCoborrower2RelationWithBorrower(String coborrower2RelationWithBorrower) {
        this.coborrower2RelationWithBorrower = coborrower2RelationWithBorrower;
    }

    public String getRef1Name() {
        return this.ref1Name;
    }

    public void setRef1Name(String ref1Name) {
        this.ref1Name = ref1Name;
    }

    public String getRef1ContactNo() {
        return this.ref1ContactNo;
    }

    public void setRef1ContactNo(String ref1ContactNo) {
        this.ref1ContactNo = ref1ContactNo;
    }

    public String getRef1RelationWithBorrower() {
        return this.ref1RelationWithBorrower;
    }

    public void setRef1RelationWithBorrower(String ref1RelationWithBorrower) {
        this.ref1RelationWithBorrower = ref1RelationWithBorrower;
    }

    public String getRef2Name() {
        return this.ref2Name;
    }

    public void setRef2Name(String ref2Name) {
        this.ref2Name = ref2Name;
    }

    public String getRef2ContactNo() {
        return this.ref2ContactNo;
    }

    public void setRef2ContactNo(String ref2ContactNo) {
        this.ref2ContactNo = ref2ContactNo;
    }

    public String getRef2RelationWithBorrower() {
        return this.ref2RelationWithBorrower;
    }

    public void setRef2RelationWithBorrower(String ref2RelationWithBorrower) {
        this.ref2RelationWithBorrower = ref2RelationWithBorrower;
    }

    public String getClientBusinessAddress() {
        return this.clientBusinessAddress;
    }

    public void setClientBusinessAddress(String clientBusinessAddress) {
        this.clientBusinessAddress = clientBusinessAddress;
    }

    public Integer getCreditLimitApproval() {
        return this.creditLimitApproval;
    }

    public void setCreditLimitApproval(Integer creditLimitApproval) {
        this.creditLimitApproval = creditLimitApproval;
    }

    public Instant getCreditApprovalDate() {
        return this.creditApprovalDate;
    }

    public void setCreditApprovalDate(Instant creditApprovalDate) {
        this.creditApprovalDate = creditApprovalDate;
    }

    public Integer getCreditApprovedBy() {
        return this.creditApprovedBy;
    }

    public void setCreditApprovedBy(Integer creditApprovedBy) {
        this.creditApprovedBy = creditApprovedBy;
    }

    public BigDecimal getDistBwPvBranch() {
        return this.distBwPvBranch;
    }

    public void setDistBwPvBranch(BigDecimal distBwPvBranch) {
        this.distBwPvBranch = distBwPvBranch;
    }

    public Instant getCgtDate() {
        return this.cgtDate;
    }

    public void setCgtDate(Instant cgtDate) {
        this.cgtDate = cgtDate;
    }

    public Integer getCgtApprovalStatus() {
        return this.cgtApprovalStatus;
    }

    public void setCgtApprovalStatus(Integer cgtApprovalStatus) {
        this.cgtApprovalStatus = cgtApprovalStatus;
    }

    public Instant getCgtDateDay2() {
        return this.cgtDateDay2;
    }

    public void setCgtDateDay2(Instant cgtDateDay2) {
        this.cgtDateDay2 = cgtDateDay2;
    }

    public Integer getCgtApprovalStatusDay2() {
        return this.cgtApprovalStatusDay2;
    }

    public void setCgtApprovalStatusDay2(Integer cgtApprovalStatusDay2) {
        this.cgtApprovalStatusDay2 = cgtApprovalStatusDay2;
    }

    public String getEquifaxScoreRetail() {
        return this.equifaxScoreRetail;
    }

    public void setEquifaxScoreRetail(String equifaxScoreRetail) {
        this.equifaxScoreRetail = equifaxScoreRetail;
    }

    public String getEquifaxScoreMicrofinance() {
        return this.equifaxScoreMicrofinance;
    }

    public void setEquifaxScoreMicrofinance(String equifaxScoreMicrofinance) {
        this.equifaxScoreMicrofinance = equifaxScoreMicrofinance;
    }

    public Double getDistBwCgtBranch() {
        return this.distBwCgtBranch;
    }

    public void setDistBwCgtBranch(Double distBwCgtBranch) {
        this.distBwCgtBranch = distBwCgtBranch;
    }

    public Double getDistBwGrtBranch() {
        return this.distBwGrtBranch;
    }

    public void setDistBwGrtBranch(Double distBwGrtBranch) {
        this.distBwGrtBranch = distBwGrtBranch;
    }

    public String getBorrowerMotherFirstName() {
        return this.borrowerMotherFirstName;
    }

    public void setBorrowerMotherFirstName(String borrowerMotherFirstName) {
        this.borrowerMotherFirstName = borrowerMotherFirstName;
    }

    public String getBorrowerMotherLastName() {
        return this.borrowerMotherLastName;
    }

    public void setBorrowerMotherLastName(String borrowerMotherLastName) {
        this.borrowerMotherLastName = borrowerMotherLastName;
    }

    public String getCoBorrowerMotherLastName() {
        return this.coBorrowerMotherLastName;
    }

    public void setCoBorrowerMotherLastName(String coBorrowerMotherLastName) {
        this.coBorrowerMotherLastName = coBorrowerMotherLastName;
    }

    public String getCoBorrowerMotherFirstName() {
        return this.coBorrowerMotherFirstName;
    }

    public void setCoBorrowerMotherFirstName(String coBorrowerMotherFirstName) {
        this.coBorrowerMotherFirstName = coBorrowerMotherFirstName;
    }

    public String getHomeVerRemarks() {
        return this.homeVerRemarks;
    }

    public void setHomeVerRemarks(String homeVerRemarks) {
        this.homeVerRemarks = homeVerRemarks;
    }

    public String getAppidDeleteRemark() {
        return this.appidDeleteRemark;
    }

    public void setAppidDeleteRemark(String appidDeleteRemark) {
        this.appidDeleteRemark = appidDeleteRemark;
    }

    public String getCflSerialNo() {
        return this.cflSerialNo;
    }

    public void setCflSerialNo(String cflSerialNo) {
        this.cflSerialNo = cflSerialNo;
    }

    public Integer getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getIdfcPosidex() {
        return this.idfcPosidex;
    }

    public void setIdfcPosidex(String idfcPosidex) {
        this.idfcPosidex = idfcPosidex;
    }

    public String getIdfcLoanCreation() {
        return this.idfcLoanCreation;
    }

    public void setIdfcLoanCreation(String idfcLoanCreation) {
        this.idfcLoanCreation = idfcLoanCreation;
    }

    public Integer getMoveMblToCml() {
        return this.moveMblToCml;
    }

    public void setMoveMblToCml(Integer moveMblToCml) {
        this.moveMblToCml = moveMblToCml;
    }

    public Instant getMoveMblToCmlDate() {
        return this.moveMblToCmlDate;
    }

    public void setMoveMblToCmlDate(Instant moveMblToCmlDate) {
        this.moveMblToCmlDate = moveMblToCmlDate;
    }

    public Integer getMoveByMblToCml() {
        return this.moveByMblToCml;
    }

    public void setMoveByMblToCml(Integer moveByMblToCml) {
        this.moveByMblToCml = moveByMblToCml;
    }

    public String getIdfcLoanStatusCheck() {
        return this.idfcLoanStatusCheck;
    }

    public void setIdfcLoanStatusCheck(String idfcLoanStatusCheck) {
        this.idfcLoanStatusCheck = idfcLoanStatusCheck;
    }

    public Integer getLeadId() {
        return this.leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public Instant getIdfcPosidexEntryDate() {
        return this.idfcPosidexEntryDate;
    }

    public void setIdfcPosidexEntryDate(Instant idfcPosidexEntryDate) {
        this.idfcPosidexEntryDate = idfcPosidexEntryDate;
    }

    public Instant getIdfcLoanCreationEntryDate() {
        return this.idfcLoanCreationEntryDate;
    }

    public void setIdfcLoanCreationEntryDate(Instant idfcLoanCreationEntryDate) {
        this.idfcLoanCreationEntryDate = idfcLoanCreationEntryDate;
    }

    public Integer getSentToIdfc() {
        return this.sentToIdfc;
    }

    public void setSentToIdfc(Integer sentToIdfc) {
        this.sentToIdfc = sentToIdfc;
    }

    public Integer getAutoRenewalStatus() {
        return this.autoRenewalStatus;
    }

    public void setAutoRenewalStatus(Integer autoRenewalStatus) {
        this.autoRenewalStatus = autoRenewalStatus;
    }

    public String getUpdatedAddressField() {
        return this.updatedAddressField;
    }

    public void setUpdatedAddressField(String updatedAddressField) {
        this.updatedAddressField = updatedAddressField;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getLoanApplicationNo() {
        return this.loanApplicationNo;
    }

    public void setLoanApplicationNo(Integer loanApplicationNo) {
        this.loanApplicationNo = loanApplicationNo;
    }

    public String getCoborrowerupdatedaddressfield() {
        return this.coborrowerupdatedaddressfield;
    }

    public void setCoborrowerupdatedaddressfield(String coborrowerupdatedaddressfield) {
        this.coborrowerupdatedaddressfield = coborrowerupdatedaddressfield;
    }

    public String getClientpancard() {
        return this.clientpancard;
    }

    public void setClientpancard(String clientpancard) {
        this.clientpancard = clientpancard;
    }

    public String getCoborrowerpancard() {
        return this.coborrowerpancard;
    }

    public void setCoborrowerpancard(String coborrowerpancard) {
        this.coborrowerpancard = coborrowerpancard;
    }

    public Instant getCenterMeetingDate() {
        return this.centerMeetingDate;
    }

    public void setCenterMeetingDate(Instant centerMeetingDate) {
        this.centerMeetingDate = centerMeetingDate;
    }

    public Integer getMeetingDateCenter() {
        return this.meetingDateCenter;
    }

    public void setMeetingDateCenter(Integer meetingDateCenter) {
        this.meetingDateCenter = meetingDateCenter;
    }

    public Double getDistBwCenterBranch() {
        return this.distBwCenterBranch;
    }

    public void setDistBwCenterBranch(Double distBwCenterBranch) {
        this.distBwCenterBranch = distBwCenterBranch;
    }

    public Integer getCenterMeetingId() {
        return this.centerMeetingId;
    }

    public void setCenterMeetingId(Integer centerMeetingId) {
        this.centerMeetingId = centerMeetingId;
    }

    public Integer getContactAvailable() {
        return this.contactAvailable;
    }

    public void setContactAvailable(Integer contactAvailable) {
        this.contactAvailable = contactAvailable;
    }

    public Integer getWithCentre() {
        return this.withCentre;
    }

    public void setWithCentre(Integer withCentre) {
        this.withCentre = withCentre;
    }

    public Integer getDflApplicantclientid() {
        return this.dflApplicantclientid;
    }

    public void setDflApplicantclientid(Integer dflApplicantclientid) {
        this.dflApplicantclientid = dflApplicantclientid;
    }

    public Integer getDflCoapplicantclientid() {
        return this.dflCoapplicantclientid;
    }

    public void setDflCoapplicantclientid(Integer dflCoapplicantclientid) {
        this.dflCoapplicantclientid = dflCoapplicantclientid;
    }

    public String getDflLoanAppStatus() {
        return this.dflLoanAppStatus;
    }

    public void setDflLoanAppStatus(String dflLoanAppStatus) {
        this.dflLoanAppStatus = dflLoanAppStatus;
    }

    public Integer getMatchScore() {
        return this.matchScore;
    }

    public void setMatchScore(Integer matchScore) {
        this.matchScore = matchScore;
    }

    public Integer getUserApprovalStatus() {
        return this.userApprovalStatus;
    }

    public void setUserApprovalStatus(Integer userApprovalStatus) {
        this.userApprovalStatus = userApprovalStatus;
    }

    public Instant getUserApprovalDate() {
        return this.userApprovalDate;
    }

    public void setUserApprovalDate(Instant userApprovalDate) {
        this.userApprovalDate = userApprovalDate;
    }

    public String getFinalJsonBorrower() {
        return this.finalJsonBorrower;
    }

    public void setFinalJsonBorrower(String finalJsonBorrower) {
        this.finalJsonBorrower = finalJsonBorrower;
    }

    public String getFinalJsonCoBorrower() {
        return this.finalJsonCoBorrower;
    }

    public void setFinalJsonCoBorrower(String finalJsonCoBorrower) {
        this.finalJsonCoBorrower = finalJsonCoBorrower;
    }

    public Integer getContactAvailableSize() {
        return this.contactAvailableSize;
    }

    public void setContactAvailableSize(Integer contactAvailableSize) {
        this.contactAvailableSize = contactAvailableSize;
    }

    public String getBureauMobileno() {
        return this.bureauMobileno;
    }

    public void setBureauMobileno(String bureauMobileno) {
        this.bureauMobileno = bureauMobileno;
    }

    public String getBureauVoterid() {
        return this.bureauVoterid;
    }

    public void setBureauVoterid(String bureauVoterid) {
        this.bureauVoterid = bureauVoterid;
    }

    public Long getLbUserId() {
        return this.lbUserId;
    }

    public void setLbUserId(Long lbUserId) {
        this.lbUserId = lbUserId;
    }

    public Long getLbLoanId() {
        return this.lbLoanId;
    }

    public void setLbLoanId(Long lbLoanId) {
        this.lbLoanId = lbLoanId;
    }

    public String getOcrJson() {
        return this.ocrJson;
    }

    public void setOcrJson(String ocrJson) {
        this.ocrJson = ocrJson;
    }

    public String getKarzaPancardDetails() {
        return this.karzaPancardDetails;
    }

    public void setKarzaPancardDetails(String karzaPancardDetails) {
        this.karzaPancardDetails = karzaPancardDetails;
    }

    public String getCoBorrowerOcrResponse() {
        return this.coBorrowerOcrResponse;
    }

    public void setCoBorrowerOcrResponse(String coBorrowerOcrResponse) {
        this.coBorrowerOcrResponse = coBorrowerOcrResponse;
    }

    public String getDigitapOkycJson() {
        return this.digitapOkycJson;
    }

    public void setDigitapOkycJson(String digitapOkycJson) {
        this.digitapOkycJson = digitapOkycJson;
    }

    public String getPfDetails() {
        return this.pfDetails;
    }

    public void setPfDetails(String pfDetails) {
        this.pfDetails = pfDetails;
    }

    public Integer getEmployeeType() {
        return this.employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getDocDeletedStatus() {
        return this.docDeletedStatus;
    }

    public void setDocDeletedStatus(Integer docDeletedStatus) {
        this.docDeletedStatus = docDeletedStatus;
    }

    public Instant getDocDeletedDate() {
        return this.docDeletedDate;
    }

    public void setDocDeletedDate(Instant docDeletedDate) {
        this.docDeletedDate = docDeletedDate;
    }

    public String getDocDeletedRemark() {
        return this.docDeletedRemark;
    }

    public void setDocDeletedRemark(String docDeletedRemark) {
        this.docDeletedRemark = docDeletedRemark;
    }

    public String getMagicUdhyamJson() {
        return this.magicUdhyamJson;
    }

    public void setMagicUdhyamJson(String magicUdhyamJson) {
        this.magicUdhyamJson = magicUdhyamJson;
    }

    public Instant getUanDate() {
        return this.uanDate;
    }

    public void setUanDate(Instant uanDate) {
        this.uanDate = uanDate;
    }

    public String getEmployerName() {
        return this.employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getMobileDetailsJson() {
        return this.mobileDetailsJson;
    }

    public void setMobileDetailsJson(String mobileDetailsJson) {
        this.mobileDetailsJson = mobileDetailsJson;
    }

    public Integer getLoanSanctionStatus() {
        return this.loanSanctionStatus;
    }

    public void setLoanSanctionStatus(Integer loanSanctionStatus) {
        this.loanSanctionStatus = loanSanctionStatus;
    }

    public String getCommonAccountDetectionJson() {
        return this.commonAccountDetectionJson;
    }

    public void setCommonAccountDetectionJson(String commonAccountDetectionJson) {
        this.commonAccountDetectionJson = commonAccountDetectionJson;
    }

    public String getSimServiceType() {
        return this.simServiceType;
    }

    public void setSimServiceType(String simServiceType) {
        this.simServiceType = simServiceType;
    }

    public String getNameMatchingJson() {
        return this.nameMatchingJson;
    }

    public void setNameMatchingJson(String nameMatchingJson) {
        this.nameMatchingJson = nameMatchingJson;
    }

    public LocalDate getMobileActivationDate() {
        return this.mobileActivationDate;
    }

    public void setMobileActivationDate(LocalDate mobileActivationDate) {
        this.mobileActivationDate = mobileActivationDate;
    }

    public String getMobileUnbilledBalance() {
        return this.mobileUnbilledBalance;
    }

    public void setMobileUnbilledBalance(String mobileUnbilledBalance) {
        this.mobileUnbilledBalance = mobileUnbilledBalance;
    }

    public String getMobileTotalOutstandingAmount() {
        return this.mobileTotalOutstandingAmount;
    }

    public void setMobileTotalOutstandingAmount(String mobileTotalOutstandingAmount) {
        this.mobileTotalOutstandingAmount = mobileTotalOutstandingAmount;
    }

    public String getIsMobileNameMatch() {
        return this.isMobileNameMatch;
    }

    public void setIsMobileNameMatch(String isMobileNameMatch) {
        this.isMobileNameMatch = isMobileNameMatch;
    }

    public String getIsPanNameMatch() {
        return this.isPanNameMatch;
    }

    public void setIsPanNameMatch(String isPanNameMatch) {
        this.isPanNameMatch = isPanNameMatch;
    }

    public String getApplicableUanNumber() {
        return this.applicableUanNumber;
    }

    public void setApplicableUanNumber(String applicableUanNumber) {
        this.applicableUanNumber = applicableUanNumber;
    }

    public String getApplicableDateOfJoining() {
        return this.applicableDateOfJoining;
    }

    public void setApplicableDateOfJoining(String applicableDateOfJoining) {
        this.applicableDateOfJoining = applicableDateOfJoining;
    }

    public String getCurrentOrganisationName() {
        return this.currentOrganisationName;
    }

    public void setCurrentOrganisationName(String currentOrganisationName) {
        this.currentOrganisationName = currentOrganisationName;
    }

    public String getMobileRegisteredName() {
        return this.mobileRegisteredName;
    }

    public void setMobileRegisteredName(String mobileRegisteredName) {
        this.mobileRegisteredName = mobileRegisteredName;
    }

    public String getEpfRemark() {
        return this.epfRemark;
    }

    public void setEpfRemark(String epfRemark) {
        this.epfRemark = epfRemark;
    }

    public Integer getAadhaarApproveStatus() {
        return this.aadhaarApproveStatus;
    }

    public void setAadhaarApproveStatus(Integer aadhaarApproveStatus) {
        this.aadhaarApproveStatus = aadhaarApproveStatus;
    }

    public Integer getEpfApproveStatus() {
        return this.epfApproveStatus;
    }

    public void setEpfApproveStatus(Integer epfApproveStatus) {
        this.epfApproveStatus = epfApproveStatus;
    }

    public Integer getMobileApproveStatus() {
        return this.mobileApproveStatus;
    }

    public void setMobileApproveStatus(Integer mobileApproveStatus) {
        this.mobileApproveStatus = mobileApproveStatus;
    }

    public Integer getPanCardApproveStatus() {
        return this.panCardApproveStatus;
    }

    public void setPanCardApproveStatus(Integer panCardApproveStatus) {
        this.panCardApproveStatus = panCardApproveStatus;
    }

    public Instant getClientFormDate() {
        return this.clientFormDate;
    }

    public void setClientFormDate(Instant clientFormDate) {
        this.clientFormDate = clientFormDate;
    }

    public Instant getEpfVerificationDate() {
        return this.epfVerificationDate;
    }

    public void setEpfVerificationDate(Instant epfVerificationDate) {
        this.epfVerificationDate = epfVerificationDate;
    }

    public Instant getMobileVerificationDate() {
        return this.mobileVerificationDate;
    }

    public void setMobileVerificationDate(Instant mobileVerificationDate) {
        this.mobileVerificationDate = mobileVerificationDate;
    }

    public Instant getPanCardVerificationDate() {
        return this.panCardVerificationDate;
    }

    public void setPanCardVerificationDate(Instant panCardVerificationDate) {
        this.panCardVerificationDate = panCardVerificationDate;
    }

    public Instant getAadhaarVerificationDate() {
        return this.aadhaarVerificationDate;
    }

    public void setAadhaarVerificationDate(Instant aadhaarVerificationDate) {
        this.aadhaarVerificationDate = aadhaarVerificationDate;
    }

    public Instant getLoanSanctionDate() {
        return this.loanSanctionDate;
    }

    public void setLoanSanctionDate(Instant loanSanctionDate) {
        this.loanSanctionDate = loanSanctionDate;
    }

    public String getMobileOverdueDays() {
        return this.mobileOverdueDays;
    }

    public void setMobileOverdueDays(String mobileOverdueDays) {
        this.mobileOverdueDays = mobileOverdueDays;
    }

    public Integer getEquifaxJobStatus() {
        return this.equifaxJobStatus;
    }

    public void setEquifaxJobStatus(Integer equifaxJobStatus) {
        this.equifaxJobStatus = equifaxJobStatus;
    }

    public Integer getCenterApprovalStatus() {
        return this.centerApprovalStatus;
    }

    public void setCenterApprovalStatus(Integer centerApprovalStatus) {
        this.centerApprovalStatus = centerApprovalStatus;
    }

    public Integer getCenterApprovalBy() {
        return this.centerApprovalBy;
    }

    public void setCenterApprovalBy(Integer centerApprovalBy) {
        this.centerApprovalBy = centerApprovalBy;
    }

    public Instant getCenterApprovalDate() {
        return this.centerApprovalDate;
    }

    public void setCenterApprovalDate(Instant centerApprovalDate) {
        this.centerApprovalDate = centerApprovalDate;
    }

    public String getCenterApprovalMeetingDate() {
        return this.centerApprovalMeetingDate;
    }

    public void setCenterApprovalMeetingDate(String centerApprovalMeetingDate) {
        this.centerApprovalMeetingDate = centerApprovalMeetingDate;
    }

    public Integer getDigitSmsStatus() {
        return this.digitSmsStatus;
    }

    public void setDigitSmsStatus(Integer digitSmsStatus) {
        this.digitSmsStatus = digitSmsStatus;
    }

    public Instant getDigitSmsDate() {
        return this.digitSmsDate;
    }

    public void setDigitSmsDate(Instant digitSmsDate) {
        this.digitSmsDate = digitSmsDate;
    }

    public String getBorrowerAdressLine1() {
        return this.borrowerAdressLine1;
    }

    public void setBorrowerAdressLine1(String borrowerAdressLine1) {
        this.borrowerAdressLine1 = borrowerAdressLine1;
    }

    public String getCoborrowerAdressLine2() {
        return this.coborrowerAdressLine2;
    }

    public void setCoborrowerAdressLine2(String coborrowerAdressLine2) {
        this.coborrowerAdressLine2 = coborrowerAdressLine2;
    }

    public String getCoborrowerAdressLine1() {
        return this.coborrowerAdressLine1;
    }

    public void setCoborrowerAdressLine1(String coborrowerAdressLine1) {
        this.coborrowerAdressLine1 = coborrowerAdressLine1;
    }

    public String getBorrowerAdressLine2() {
        return this.borrowerAdressLine2;
    }

    public void setBorrowerAdressLine2(String borrowerAdressLine2) {
        this.borrowerAdressLine2 = borrowerAdressLine2;
    }

    public String getBorrowerAddress() {
        return this.borrowerAddress;
    }

    public void setBorrowerAddress(String borrowerAddress) {
        this.borrowerAddress = borrowerAddress;
    }

    public String getCoborrowerAddress() {
        return this.coborrowerAddress;
    }

    public void setCoborrowerAddress(String coborrowerAddress) {
        this.coborrowerAddress = coborrowerAddress;
    }

    public String getAadhaarName() {
        return this.aadhaarName;
    }

    public void setAadhaarName(String aadhaarName) {
        this.aadhaarName = aadhaarName;
    }

    public Integer getMaskAadhaarBorrowerCount() {
        return this.maskAadhaarBorrowerCount;
    }

    public void setMaskAadhaarBorrowerCount(Integer maskAadhaarBorrowerCount) {
        this.maskAadhaarBorrowerCount = maskAadhaarBorrowerCount;
    }

    public Integer getMaskAadhaarCoborrowerCount() {
        return this.maskAadhaarCoborrowerCount;
    }

    public void setMaskAadhaarCoborrowerCount(Integer maskAadhaarCoborrowerCount) {
        this.maskAadhaarCoborrowerCount = maskAadhaarCoborrowerCount;
    }

    public String getMaskingResponseBorrower() {
        return this.maskingResponseBorrower;
    }

    public void setMaskingResponseBorrower(String maskingResponseBorrower) {
        this.maskingResponseBorrower = maskingResponseBorrower;
    }

    public String getMaskingResponseCoborrower() {
        return this.maskingResponseCoborrower;
    }

    public void setMaskingResponseCoborrower(String maskingResponseCoborrower) {
        this.maskingResponseCoborrower = maskingResponseCoborrower;
    }

    public String getApplicationStatus() {
        return this.applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApiStatus() {
        return this.apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getCoBorrowerVoterId() {
        return this.coBorrowerVoterId;
    }

    public void setCoBorrowerVoterId(String coBorrowerVoterId) {
        this.coBorrowerVoterId = coBorrowerVoterId;
    }

    public Integer getDocsCount() {
        return this.docsCount;
    }

    public void setDocsCount(Integer docsCount) {
        this.docsCount = docsCount;
    }

    public Double getHvIncome() {
        return this.hvIncome;
    }

    public void setHvIncome(Double hvIncome) {
        this.hvIncome = hvIncome;
    }

    public Integer getFurtherDocsStatus() {
        return this.furtherDocsStatus;
    }

    public void setFurtherDocsStatus(Integer furtherDocsStatus) {
        this.furtherDocsStatus = furtherDocsStatus;
    }

    public Integer getBorrowerPancardDocStatus() {
        return this.borrowerPancardDocStatus;
    }

    public void setBorrowerPancardDocStatus(Integer borrowerPancardDocStatus) {
        this.borrowerPancardDocStatus = borrowerPancardDocStatus;
    }

    public Integer getBorrowerVoteridDocStatus() {
        return this.borrowerVoteridDocStatus;
    }

    public void setBorrowerVoteridDocStatus(Integer borrowerVoteridDocStatus) {
        this.borrowerVoteridDocStatus = borrowerVoteridDocStatus;
    }

    public Integer getCoborrowerPancardDocStatus() {
        return this.coborrowerPancardDocStatus;
    }

    public void setCoborrowerPancardDocStatus(Integer coborrowerPancardDocStatus) {
        this.coborrowerPancardDocStatus = coborrowerPancardDocStatus;
    }

    public Integer getCoborrowerVoteridDocStatus() {
        return this.coborrowerVoteridDocStatus;
    }

    public void setCoborrowerVoteridDocStatus(Integer coborrowerVoteridDocStatus) {
        this.coborrowerVoteridDocStatus = coborrowerVoteridDocStatus;
    }

    public Integer getCreditLineId() {
        return this.creditLineId;
    }

    public void setCreditLineId(Integer creditLineId) {
        this.creditLineId = creditLineId;
    }

    public String getAccountStatus() {
        return this.accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getBlockCode() {
        return this.blockCode;
    }

    public void setBlockCode(String blockCode) {
        this.blockCode = blockCode;
    }

    public String getBlockReason() {
        return this.blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    public String getLender() {
        return this.lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public Integer getIsBorrowerDocsFurther() {
        return this.isBorrowerDocsFurther;
    }

    public void setIsBorrowerDocsFurther(Integer isBorrowerDocsFurther) {
        this.isBorrowerDocsFurther = isBorrowerDocsFurther;
    }

    public Integer getIsCoborrowerDocsFurther() {
        return this.isCoborrowerDocsFurther;
    }

    public void setIsCoborrowerDocsFurther(Integer isCoborrowerDocsFurther) {
        this.isCoborrowerDocsFurther = isCoborrowerDocsFurther;
    }

    public String getCoborrowerPancardDetails() {
        return this.coborrowerPancardDetails;
    }

    public void setCoborrowerPancardDetails(String coborrowerPancardDetails) {
        this.coborrowerPancardDetails = coborrowerPancardDetails;
    }

    public String getBorrowerPancardName() {
        return this.borrowerPancardName;
    }

    public void setBorrowerPancardName(String borrowerPancardName) {
        this.borrowerPancardName = borrowerPancardName;
    }

    public String getCoborrowerPancardName() {
        return this.coborrowerPancardName;
    }

    public void setCoborrowerPancardName(String coborrowerPancardName) {
        this.coborrowerPancardName = coborrowerPancardName;
    }

    public String getCoborrowerPancardStatus() {
        return this.coborrowerPancardStatus;
    }

    public void setCoborrowerPancardStatus(String coborrowerPancardStatus) {
        this.coborrowerPancardStatus = coborrowerPancardStatus;
    }

    public String getUpiPaymentId() {
        return this.upiPaymentId;
    }

    public void setUpiPaymentId(String upiPaymentId) {
        this.upiPaymentId = upiPaymentId;
    }

    public String getUpiPaymentReason() {
        return this.upiPaymentReason;
    }

    public void setUpiPaymentReason(String upiPaymentReason) {
        this.upiPaymentReason = upiPaymentReason;
    }

    public Instant getStageStartingProcessTime() {
        return this.stageStartingProcessTime;
    }

    public void setStageStartingProcessTime(Instant stageStartingProcessTime) {
        this.stageStartingProcessTime = stageStartingProcessTime;
    }

    public Instant getStageEndingProcessTime() {
        return this.stageEndingProcessTime;
    }

    public void setStageEndingProcessTime(Instant stageEndingProcessTime) {
        this.stageEndingProcessTime = stageEndingProcessTime;
    }

    public String getConnectCurrentProcessStage() {
        return this.connectCurrentProcessStage;
    }

    public void setConnectCurrentProcessStage(String connectCurrentProcessStage) {
        this.connectCurrentProcessStage = connectCurrentProcessStage;
    }

    public Integer getCoborrowerMobileVerify() {
        return this.coborrowerMobileVerify;
    }

    public void setCoborrowerMobileVerify(Integer coborrowerMobileVerify) {
        this.coborrowerMobileVerify = coborrowerMobileVerify;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocationdegree() {
        return this.locationdegree;
    }

    public void setLocationdegree(String locationdegree) {
        this.locationdegree = locationdegree;
    }

    public String getLocationdate() {
        return this.locationdate;
    }

    public void setLocationdate(String locationdate) {
        this.locationdate = locationdate;
    }

    public String getBorrowerAadhaarPanLinkResponse() {
        return this.borrowerAadhaarPanLinkResponse;
    }

    public void setBorrowerAadhaarPanLinkResponse(String borrowerAadhaarPanLinkResponse) {
        this.borrowerAadhaarPanLinkResponse = borrowerAadhaarPanLinkResponse;
    }

    public String getCoborrowerAadhaarPanLinkResponse() {
        return this.coborrowerAadhaarPanLinkResponse;
    }

    public void setCoborrowerAadhaarPanLinkResponse(String coborrowerAadhaarPanLinkResponse) {
        this.coborrowerAadhaarPanLinkResponse = coborrowerAadhaarPanLinkResponse;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }
}
