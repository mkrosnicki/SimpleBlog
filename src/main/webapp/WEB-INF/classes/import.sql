INSERT INTO role(authority) VALUES ('ROLE_ADMIN');
INSERT INTO role(authority) VALUES ('ROLE_USER');

INSERT INTO users(user_id,enabled,username,password,imageName) VALUES (1, 1, 'maku', 'password', 'user_default.jpg');
INSERT INTO users(user_id,enabled,username,password,imageName) VALUES (2, 1, 'joanna', 'password', 'user_default.jpg');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_ADMIN', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'joanna');

INSERT INTO posts(title,text,user_id,imageName,date) VALUES ('POST NR 1','JAKIS TAM NOWY POST BLABLABLA',1,'post_default.jpg',STR_TO_DATE('12-01-2014','%d-%m-%Y'));
INSERT INTO posts(title,text,user_id,imageName,date) VALUES ('POST NR 2','POST TESTOWY NUMER 2 fhdjksfhsdkjhfksdhfjksdhfkjsd',1,'post_default.jpg',STR_TO_DATE('12-01-2015','%d-%m-%Y'));
