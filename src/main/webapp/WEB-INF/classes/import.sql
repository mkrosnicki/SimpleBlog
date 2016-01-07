INSERT INTO role(authority) VALUES ('ROLE_ADMIN');
INSERT INTO role(authority) VALUES ('ROLE_USER');

INSERT INTO users(user_id,enabled,username,password,imageName) VALUES (1, 1, 'maku', 'password', 'user_default.jpg');
INSERT INTO users(user_id,enabled,username,password,imageName) VALUES (2, 1, 'joanna', 'password', 'user_default.jpg');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_ADMIN', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'joanna');
