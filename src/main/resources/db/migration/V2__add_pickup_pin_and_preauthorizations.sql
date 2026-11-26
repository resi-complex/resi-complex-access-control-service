ALTER TABLE correspondence
    ADD COLUMN pickup_pin VARCHAR(10) NULL;

CREATE TABLE visitor_preauthorizations (
    id VARCHAR(36) PRIMARY KEY,
    unit_id VARCHAR(36) NOT NULL,
    visitor_name VARCHAR(150) NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    authorized_by VARCHAR(36) NOT NULL,
    valid_from TIMESTAMP NOT NULL,
    valid_until TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

CREATE INDEX idx_preauth_unit ON visitor_preauthorizations (unit_id);
CREATE INDEX idx_preauth_status ON visitor_preauthorizations (status);
