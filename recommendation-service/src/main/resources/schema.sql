CREATE TABLE recommendation
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    fullname       VARCHAR(255) NOT NULL,
    company_id     INT          NOT NULL,
    position_id    INT          NOT NULL,
    recommendation VARCHAR(255) NOT NULL
);