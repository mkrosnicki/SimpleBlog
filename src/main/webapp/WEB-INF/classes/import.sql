SET CHARACTER SET utf8;

INSERT INTO role(authority) VALUES ('ROLE_ADMIN');
INSERT INTO role(authority) VALUES ('ROLE_USER');

INSERT INTO users(user_id,enabled,username,password,imageName,dateOfRegister) VALUES (1, 1, 'maku', 'password', 'user_default.jpg',STR_TO_DATE('01-01-2012','%d-%m-%Y'));
INSERT INTO users(user_id,enabled,username,password,imageName,dateOfRegister) VALUES (2, 1, 'joanna', 'password', 'user_default.jpg',STR_TO_DATE('21-07-2013','%d-%m-%Y'));
INSERT INTO users(user_id,enabled,username,password,imageName,dateOfRegister) VALUES (3, 1, 'admin', 'password', 'user_default.jpg',STR_TO_DATE('17-03-2015','%d-%m-%Y'));

INSERT INTO user_roles(authority,username) VALUES ('ROLE_ADMIN', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'maku');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'joanna');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_ADMIN', 'admin');
INSERT INTO user_roles(authority,username) VALUES ('ROLE_USER', 'admin');

INSERT INTO posts(title,text,user_id,imageName,dateOfPublish) VALUES ('ąąąądupadupadupa','dupadupadupadupa',1,'post_default.jpg',STR_TO_DATE('12-01-2014','%d-%m-%Y'));


INSERT INTO posts(title,text,user_id,imageName,dateOfPublish) VALUES ('Stanisław Czerczesow o nowym piłkarzu Legii','W poniedziałek testy medyczne w Warszawie przejdzie Michail Aleksandrov. Bułgar ma podpisać półtoraroczny kontrakt. - Skoro daliśmy mu zielone światło, to oznacza, że gra dobrze - komentuje transfer Stanisław Czerczesow. Skrzydłowy od 2011 roku jest piłkarzem Łudogorca Razgrad. Do Polski ma trafić za kilkaset tysięcy euro. - Wiem, jak Aleksandrov gra, ale nie jesteśmy znajomymi. Jeśli podpisze kontrakt, wtedy się poznamy. Skoro daliśmy mu zielone światło na kontrakt z Legią, to oznacza, że gra dobrze. Jest reprezentantem Bułgarii, występował w Lidze Mistrzów i być może trafi do Legii. Jeśli tak się stanie, będzie mógł pokazać swoją przydatność do naszego zespołu - powiedział o zawodniku Czerczesow.',1,'post_default.jpg',STR_TO_DATE('12-01-2014','%d-%m-%Y'));


INSERT INTO posts(title,text,user_id,imageName,dateOfPublish) VALUES 
('Guardiola chce do City gwiazdę z Bilbao',
'Aymeric Laporte może wzmocnić Manchester City. Obrońca Athletic Bilbao kosztuje 40 milionów funtów. Na jego usługi jest chętnych więcej drużyn.
Według informacji dziennika "The Sun", Aymeric Laporte w sumie kosztowałby Manchester City około 80 milionów funtów. 40 to kwota wynikająca z klauzuli odstępnego, zaś drugie tyle to różne "dodatki", w tym 8 milionów funtów rocznie dla zawodnika.
Konkurencja w wyścigu o piłkarza Athletic Bilbao jest spora. Chce go też FC Barcelona, Paris Saint-Germain i Manchester United.',
1,
'post_default.jpg',
STR_TO_DATE('12-01-2015','%d-%m-%Y'));


INSERT INTO posts(title,text,user_id,imageName,dateOfPublish) VALUES 
('Trwa kapitalna seria Barcelony!',
'FC Barcelona nie przegrała żadnego z 34 kolejnych meczów! Spośród hiszpańskich drużyn podobnym dorobkiem mógł poszczycić się jedynie Real Madryt w sezonie 1988/1989!
Od 3 października 2015 roku FC Barcelona ani razu nie przegrała! Tamtego dnia aktualni mistrzowie Hiszpanii polegli na wyjeździe z Sevillą 1:2. W niedzielny wieczór podopieczni Luisa Enrique zrewanżowali się graczom Unaia Emeryego, pokonali Andaluzyjczyków 2:1 i zaliczyli 34 kolejny mecz bez porażki!
W tym czasie "Duma Katalonii" rywalizowała na czterech frontach - w rozgrywkach Primera Division, Ligi Mistrzów, Pucharu Króla oraz Klubowych Mistrzostw Świata. Barca zanotowała 28 zwycięstw i 6 remisów, a bilans bramkowy podczas tej fenomenalnej serii wynosi 102 goli strzelonych i 19 straconych.',
3,
'post_default.jpg',
STR_TO_DATE('18-02-2013','%d-%m-%Y'));


INSERT INTO posts(title,text,user_id,imageName,dateOfPublish) VALUES 
('Tottenham chce Mario Mandzukicia',
'Napastnik Juventusu Turyn, Mario Mandzukić, może latem trafić do Tottenham Hotspur Londyn - informuje dziennik "The Sun".
Według brytyjskiej bulwarówki Mario Mandzukić latem dostanie ofertę z londyńskiego klubu. Chorwacki napastnik Juventusu Turyn w tym sezonie w 16 meczach Serie A strzelił 6 goli. Znakomicie zaprezentował się w ubiegłym tygodniu w meczu Ligi Mistrzów ze swoim byłym pracodawcą, Bayernem Monachium.
Tottenham Hotspur liczy na udział w Lidze Mistrzów w przyszłym sezonie i pod tym kątem szuka wzmocnień. Mandzukić według medialnych doniesień miałby kosztować niecałe 20 milionów funtów.',
3,
'post_default.jpg',
STR_TO_DATE('28-05-2013','%d-%m-%Y'));