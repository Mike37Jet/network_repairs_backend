INSERT INTO repairs (repair_date, description, created_by, updated_by, created_at, updated_at)
VALUES
  (CURRENT_TIMESTAMP, 'Primera reparación', 'usuario1', 'usuario1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (CURRENT_TIMESTAMP, 'Segunda reparación', 'usuario2', 'usuario2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);