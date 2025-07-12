CREATE TABLE IF NOT EXISTS users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT references users(id),
    roles TEXT NOT NULL
);

-- default user
INSERT INTO users (username, password) VALUES ('admin', 'admin');
INSERT INTO user_roles SELECT id, 'ADMIN' FROM users WHERE username = 'admin';