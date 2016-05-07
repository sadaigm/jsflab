package com.sa.tcm.entity;



import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sadaiyandi
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Runner.findAll", query = "SELECT r FROM Runner r order by r.runnerId desc"),
    @NamedQuery(name = "Runner.findByRunnerId", query = "SELECT r FROM Runner r WHERE r.runnerId = :runnerId"),
    @NamedQuery(name = "Runner.findByTestCaseId", query = "SELECT r FROM Runner r WHERE r.testCaseId = :testCaseId"),
    @NamedQuery(name = "Runner.findByStatus", query = "SELECT r FROM Runner r WHERE r.status = :status"),
    @NamedQuery(name = "Runner.findByBuildno", query = "SELECT r FROM Runner r WHERE r.buildno = :buildno"),
    @NamedQuery(name = "Runner.findByDefectid", query = "SELECT r FROM Runner r WHERE r.defectid = :defectid"),
    @NamedQuery(name = "Runner.findByTester", query = "SELECT r FROM Runner r WHERE r.tester = :tester"),
    @NamedQuery(name = "Runner.findByExecuteddate", query = "SELECT r FROM Runner r WHERE r.executeddate = :executeddate"),
    @NamedQuery(name = "Runner.findLikeExecuteddate", query = "SELECT r FROM Runner r WHERE r.executeddate >= :executeddate"),
    @NamedQuery(name = "Runner.findByComments", query = "SELECT r FROM Runner r WHERE r.comments = :comments")})
public class Runner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "runner_id", nullable = false)
    private Integer runnerId;
    @Size(max = 1200)
    @Column(name = "test_case_id", length = 1200)
    private String testCaseId;
    @Size(max = 12)
    @Column(name = "Status", length = 12)
    private String status;
    @Size(max = 100)
    @Column(name = "Build_no", length = 100)
    private String buildno;
    @Size(max = 100)
    @Column(name = "Defect_id",length = 100)
    private String defectid;
    @Size(max = 12)
    @Column(name = "tester", length = 12)
    private String tester;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Executed_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date executeddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdatedate;
    public Date getLastupdatedate() {
		return lastupdatedate;
	}

	public void setLastupdatedate(Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}

	@Size(max = 4500)
    @Column(name = "Comments", length = 4500)
    private String comments;

    public Runner() {
    }

    public Runner(Integer runnerId) {
        this.runnerId = runnerId;
    }

    public Runner(Integer runnerId, Date executeddate) {
        this.runnerId = runnerId;
        this.executeddate = executeddate;
    }

    public Integer getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Integer runnerId) {
        this.runnerId = runnerId;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBuildno() {
        return buildno;
    }

    public void setBuildno(String buildno) {
        this.buildno = buildno;
    }

    public String getDefectid() {
        return defectid;
    }

    public void setDefectid(String defectid) {
        this.defectid = defectid;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public Date getExecuteddate() {
        return executeddate;
    }

    public void setExecuteddate(Date executeddate) {
        this.executeddate = executeddate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

   /* @Override
    public int hashCode() {
        int hash = 0;
        hash += (runnerId != null ? runnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Runner)) {
            return false;
        }
        Runner other = (Runner) object;
        if ((this.runnerId == null && other.runnerId != null) || (this.runnerId != null && !this.runnerId.equals(other.runnerId))) {
            return false;
        }
        return true;
    }
*/
    
    
    @Override
    public boolean equals(Object obj) {
            if(obj == null)
                    return false;
            
            if(!(obj instanceof Runner))
                    return false;
            
            Runner compare = (Runner) obj;
            
            if ((this.runnerId == null) ? (compare.runnerId != null) : !this.runnerId.equals(compare.runnerId)) {
                return false;
            }
            return true;
           
    }

    @Override
    public int hashCode() {
            int hash = 1;
            
        return hash * 31 + runnerId.hashCode();
    }
    
    @Override
    public String toString() {
        return "com.sa.tcm.model.Runner[ runnerId=" + runnerId + " ]";
    }
    
    
}
