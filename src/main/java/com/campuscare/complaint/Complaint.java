package com.campuscare.complaint;
import jakarta.persistence.*;import jakarta.validation.constraints.NotBlank;import jakarta.validation.constraints.Size;import java.time.LocalDateTime;
@Entity @Table(name="complaints") public class Complaint {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@Column(nullable=false,unique=true,length=24) private String ticketId;
@NotBlank @Size(max=180) @Column(nullable=false) private String title;
@NotBlank @Size(max=60) @Column(nullable=false) private String category;
@NotBlank @Size(max=180) @Column(nullable=false) private String location;
@Column(nullable=false,length=16) private String priority="MEDIUM";
@Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private ComplaintStatus status=ComplaintStatus.OPEN;
@NotBlank @Size(max=100) @Column(nullable=false) private String reporter;
@Size(max=2000) @Column(length=2000) private String description;
@Column(length=100) private String assignee="Unassigned";
@Column(nullable=false) private LocalDateTime createdAt;
private LocalDateTime updatedAt;
@PrePersist void onCreate(){createdAt=LocalDateTime.now();updatedAt=createdAt;if(ticketId==null||ticketId.isBlank())ticketId="CC-"+System.currentTimeMillis();}
@PreUpdate void onUpdate(){updatedAt=LocalDateTime.now();}
public Long getId(){return id;} public String getTicketId(){return ticketId;} public void setTicketId(String v){ticketId=v;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} public String getPriority(){return priority;} public void setPriority(String v){priority=v;} public ComplaintStatus getStatus(){return status;} public void setStatus(ComplaintStatus v){status=v;} public String getReporter(){return reporter;} public void setReporter(String v){reporter=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getAssignee(){return assignee;} public void setAssignee(String v){assignee=v;} public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
}