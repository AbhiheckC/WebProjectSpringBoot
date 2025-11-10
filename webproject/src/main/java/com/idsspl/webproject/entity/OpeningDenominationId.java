package com.idsspl.webproject.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OpeningDenominationId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "agent_id")
    private String agentId;

    @Column(name = "denominationdate")
    private String denominationDate;

    // Constructors
    public OpeningDenominationId() {}

    public OpeningDenominationId(String agentId, String denominationDate) {
        this.agentId = agentId;
        this.denominationDate = denominationDate;
    }

    // Getters and setters
    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getDenominationDate() {
        return denominationDate;
    }

    public void setDenominationDate(String denominationDate) {
        this.denominationDate = denominationDate;
    }

    // equals and hashCode are required for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpeningDenominationId)) return false;
        OpeningDenominationId that = (OpeningDenominationId) o;
        return Objects.equals(agentId, that.agentId) &&
               Objects.equals(denominationDate, that.denominationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agentId, denominationDate);
    }
}
