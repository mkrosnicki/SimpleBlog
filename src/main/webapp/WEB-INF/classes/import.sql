INSERT INTO users(user_id,enabled,username,password) VALUES (1, 1, 'maku', 'password');
INSERT INTO users(user_id,enabled,username,password) VALUES (2, 1, 'joanna', 'pupkekrolem');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_ADMIN', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'joanna');
