CREATE TABLE visits (
    id VARCHAR(36) PRIMARY KEY,
    visitor_name VARCHAR(150) NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    destination_unit_id VARCHAR(36) NOT NULL,
    visit_type VARCHAR(30) NOT NULL,
    vehicle_plate VARCHAR(20) NULL,
    vehicle_type VARCHAR(20) NULL,
    entry_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    exit_time TIMESTAMP NULL,
    guard_user_id VARCHAR(36) NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

CREATE TABLE correspondence (
    id VARCHAR(36) PRIMARY KEY,
    unit_id VARCHAR(36) NOT NULL,
    recipient_name VARCHAR(150) NOT NULL,
    package_type VARCHAR(50) NOT NULL,
    tracking_or_courier VARCHAR(100) NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING_PICKUP',
    received_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delivered_at TIMESTAMP NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL
);

CREATE INDEX idx_visits_status ON visits (status);
CREATE INDEX idx_visits_unit ON visits (destination_unit_id);
CREATE INDEX idx_corr_unit ON correspondence (unit_id);
