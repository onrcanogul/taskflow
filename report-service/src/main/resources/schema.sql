CREATE TABLE IF NOT EXISTS reports (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_date TIMESTAMP,
    updated_by VARCHAR(255),
    user_id UUID NOT NULL,
    completed_tasks INTEGER NOT NULL,
    active_tasks INTEGER NOT NULL,
    level INTEGER NOT NULL,
    points INTEGER NOT NULL,
    report_type INTEGER NOT NULL
);
