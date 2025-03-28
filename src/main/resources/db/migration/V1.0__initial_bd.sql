
CREATE TABLE repair (
    id SERIAL PRIMARY KEY,
    repair_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(255),
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

CREATE TABLE repair_images_before (
    id SERIAL PRIMARY KEY,
    repair_id INTEGER NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    taken_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_repair_before FOREIGN KEY (repair_id) REFERENCES repair (id)
);

CREATE TABLE repair_images_after (
    id SERIAL PRIMARY KEY,
    repair_id INTEGER NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    taken_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_repair_after FOREIGN KEY (repair_id) REFERENCES repair (id)
);