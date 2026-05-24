ALTER TABLE notes
    ADD CONSTRAINT uk_notes_title UNIQUE (title);