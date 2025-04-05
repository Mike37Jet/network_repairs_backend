-- Insertar registros en la tabla repair_images_before
INSERT INTO repair_images_before (repair_id, image_url, taken_at, created_by, updated_by, created_at, updated_at)
VALUES
  (1, 'http://example.com/before_image1.jpg', CURRENT_TIMESTAMP, 'usuario1', 'usuario1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, 'http://example.com/before_image2.jpg', CURRENT_TIMESTAMP, 'usuario2', 'usuario2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insertar registros en la tabla repair_images_after
INSERT INTO repair_images_after (repair_id, image_url, taken_at, created_by, updated_by, created_at, updated_at)
VALUES
  (1, 'http://example.com/after_image1.jpg', CURRENT_TIMESTAMP, 'usuario1', 'usuario1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, 'http://example.com/after_image2.jpg', CURRENT_TIMESTAMP, 'usuario2', 'usuario2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);