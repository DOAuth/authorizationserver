package com.example.authorizationserver.scim.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class ScimResourceEntity extends AbstractPersistable<Long> implements Serializable {

    @NotNull
    private UUID identifier;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String externalId;

    public ScimResourceEntity() {
    }

    public ScimResourceEntity(UUID identifier, String externalId) {
        this.identifier = identifier;
        this.externalId = externalId;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("identifier", identifier)
                .append("externalId", externalId)
                .toString();
    }
}
