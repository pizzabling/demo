
CREATE TABLE IF NOT EXISTS workers
(
    id          INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    workerId    VARCHAR(30),
    rent        DOUBLE,
    janRent     DOUBLE,
    febRent     DOUBLE,
    marRent     DOUBLE,
    aprRent     DOUBLE,
    mayRent     DOUBLE,
    juneRent    DOUBLE,
    julyRent    DOUBLE,
    augRent     DOUBLE,
    sepRent     DOUBLE,
    octRent     DOUBLE,
    novRent     DOUBLE,
    decRent     DOUBLE,
    name        TEXT,
    ratio       DOUBLE,
    comment     TEXT,

    bond        DOUBLE,
    kent        DOUBLE,
    parlament   DOUBLE,
    winston     DOUBLE,
    lm          DOUBLE,
    malboro     DOUBLE,
    rotmans     DOUBLE,
    ld          DOUBLE,
    fmorris     DOUBLE,
    aliance     DOUBLE,
    java        DOUBLE,
    optima      DOUBLE,
    petr        DOUBLE,
    maksim      DOUBLE,
    crests      DOUBLE,
    vog         DOUBLE,
    glamur      DOUBLE,
    kiss        DOUBLE,
    esse        DOUBLE,
    quin        DOUBLE,
    lady        DOUBLE,
    mor         DOUBLE,
    chester     DOUBLE,
    radopy      DOUBLE,
    stuardessa  DOUBLE,
    stolichniye DOUBLE,
    donskoy     DOUBLE,
    troyka      DOUBLE,
    fast        DOUBLE,
    royal       DOUBLE,
    manchester  DOUBLE,
    prestigue   DOUBLE,
    premier     DOUBLE,
    cosmos      DOUBLE,
    next        DOUBLE,
    magnat      DOUBLE,
    minsk       DOUBLE,
    souz        DOUBLE
);


CREATE TABLE IF NOT EXISTS SIGARETS
(
    id          INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    bond        DOUBLE,
    kent        DOUBLE,
    parlament   DOUBLE,
    winston     DOUBLE,
    lm          DOUBLE,
    malboro     DOUBLE,
    rotmans     DOUBLE,
    ld          DOUBLE,
    fmorris     DOUBLE,
    aliance     DOUBLE,
    java        DOUBLE,
    optima      DOUBLE,
    petr        DOUBLE,
    maksim      DOUBLE,
    crests      DOUBLE,
    vog         DOUBLE,
    glamur      DOUBLE,
    kiss        DOUBLE,
    esse        DOUBLE,
    quin        DOUBLE,
    lady        DOUBLE,
    mor         DOUBLE,
    chester     DOUBLE,
    radopy      DOUBLE,
    stuardessa  DOUBLE,
    stolichniye DOUBLE,
    donskoy     DOUBLE,
    troyka      DOUBLE,
    fast        DOUBLE,
    royal       DOUBLE,
    manchester  DOUBLE,
    prestigue   DOUBLE,
    premier     DOUBLE,
    cosmos      DOUBLE,
    next        DOUBLE,
    magnat      DOUBLE,
    minsk       DOUBLE,
    souz        DOUBLE
);

CREATE TABLE IF NOT EXISTS TemporaryResultForSigarets
(
    id          INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    bond        DOUBLE,
    kent        DOUBLE,
    parlament   DOUBLE,
    winston     DOUBLE,
    lm          DOUBLE,
    malboro     DOUBLE,
    rotmans     DOUBLE,
    ld          DOUBLE,
    fmorris     DOUBLE,
    aliance     DOUBLE,
    java        DOUBLE,
    optima      DOUBLE,
    petr        DOUBLE,
    maksim      DOUBLE,
    crests      DOUBLE,
    vog         DOUBLE,
    glamur      DOUBLE,
    kiss        DOUBLE,
    esse        DOUBLE,
    quin        DOUBLE,
    lady        DOUBLE,
    mor         DOUBLE,
    chester     DOUBLE,
    radopy      DOUBLE,
    stuardessa  DOUBLE,
    stolichniye DOUBLE,
    donskoy     DOUBLE,
    troyka      DOUBLE,
    fast        DOUBLE,
    royal       DOUBLE,
    manchester  DOUBLE,
    prestigue   DOUBLE,
    premier     DOUBLE,
    cosmos      DOUBLE,
    next        DOUBLE,
    magnat      DOUBLE,
    minsk       DOUBLE,
    souz        DOUBLE
);

CREATE TABLE IF NOT EXISTS SIGARETSRESULT
(
    id                integer primary key auto_increment,
    firstId           integer,
    secondId          integer,
    okladFirst        integer,
    okladSecond       integer,
    sumBond           double,
    sumKent           double,
    sumParlament      double,
    sumWinston        double,
    sumLm             double,
    sumMalboro        double,
    sumRotmans        double,
    sumLd             double,
    sumFmorris        double,
    sumAliance        double,
    sumJava           double,
    sumOptima         double,
    sumPetr           double,
    sumMaksim         double,
    sumCrests         double,
    sumVog            double,
    sumGlamur         double,
    sumKiss           double,
    sumEsse           double,
    sumQuin           double,
    sumLady           double,
    sumMor            double,
    sumChester        double,
    sumRadopy         double,
    sumStuardessa     double,
    sumStolichniye    double,
    sumDonskoy        double,
    sumTroyka         double,
    sumFast           double,
    sumRoyal          double,
    sumManchester     double,
    sumPrestigue      double,
    sumPremier        double,
    sumCosmos         double,
    sumNext           double,
    sumMagnat         double,
    sumMinsk          double,
    sumSouz           double,

    resultBond        double,
    resultKent        double,
    resultParlament   double,
    resultWinston     double,
    resultLm          double,
    resultMalboro     double,
    resultRotmans     double,
    resultLd          double,
    resultFmorris     double,
    resultAliance     double,
    resultJava        double,
    resultOptima      double,
    resultPetr        double,
    resultMaksim      double,
    resultCrests      double,
    resultVog         double,
    resultGlamur      double,
    resultKiss        double,
    resultEsse        double,
    resultQuin        double,
    resultLady        double,
    resultMor         double,
    resultChester     double,
    resultRadopy      double,
    resultStuardessa  double,
    resultStolichniye double,
    resultDonskoy     double,
    resultTroyka      double,
    resultFast        double,
    resultRoyal       double,
    resultManchester  double,
    resultPrestigue   double,
    resultPremier     double,
    resultCosmos      double,
    resultNext        double,
    resultMagnat      double,
    resultMinsk       double,
    resultSouz        double,

    coefBond          double,
    coefKent          double,
    coefParlament     double,
    coefWinston       double,
    coefLm            double,
    coefMalboro       double,
    coefRotmans       double,
    coefLd            double,
    coefFmorris       double,
    coefAliance       double,
    coefJava          double,
    coefOptima        double,
    coefPetr          double,
    coefMaksim        double,
    coefCrests        double,
    coefVog           double,
    coefGlamur        double,
    coefKiss          double,
    coefEsse          double,
    coefQuin          double,
    coefLady          double,
    coefMor           double,
    coefChester       double,
    coefRadopy        double,
    coefStuardessa    double,
    coefStolichniye   double,
    coefDonskoy       double,
    coefTroyka        double,
    coefFast          double,
    coefRoyal         double,
    coefManchester    double,
    coefPrestigue     double,
    coefPremier       double,
    coefCosmos        double,
    coefNext          double,
    coefMagnat        double,
    coefMinsk         double,
    coefSouz          double
);

CREATE TABLE IF NOT EXISTS parameters
(
    id          integer,
    parameter1  double,
    parameter2  double,
    parameter3  double,
    parameter4  double,
    parameter5  double,
    parameter6  double,
    parameter7  double,
    parameter8  double,
    parameter9  double,
    parameter10 double,
    parameter11 double,
    parameter12 double,
    parameter13 double,
    parameter14 double,
    parameter15 double,
    parameter16 double,
    parameter17 double,
    parameter18 double,
    parameter19 double,
    parameter20 double,
    parameter21 double,
    parameter22 double,
    parameter23 double,
    parameter24 double,
    parameter25 double,
    parameter26 double,
    parameter27 double,
    parameter28 double,
    parameter29 double,
    parameter30 double,
    parameter31 double,
    parameter32 double,
    parameter33 double,
    parameter34 double,
    parameter35 double,
    parameter36 double,
    parameter37 double,
    parameter38 double
);


CREATE TABLE IF NOT EXISTS bestWorkers
(
    bestId   INTEGER,
    bestRent DOUBLE
);


CREATE TABLE IF NOT EXISTS rent
(
    id   INTEGER,
    rent DOUBLE
);


CREATE TABLE IF NOT EXISTS group2
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    workerFirst int,
    workerSecond int,
    SALARYPERCENTFIRST int,
    SALARYPERCENTSECOND int,
    rentFirst double,
    rentSecond double,
    expenses double
);


CREATE TABLE IF NOT EXISTS group3
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    workerFirst int,
    workerSecond int,
    workerThird int,
    rentFirst double,
    rentSecond double,
    rentThird double,
    expenses double
);

CREATE TABLE IF NOT EXISTS group4
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    workerFirst int,
    workerSecond int,
    workerThird int,
    workerFourth int,
    rentFirst double,
    rentSecond double,
    rentThird double,
    rentFourth double,
    expenses double
);

CREATE TABLE IF NOT EXISTS group6
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    workerFirst int,
    workerSecond int,
    workerThird int,
    workerFourth int,
    workerFifth int,
    workerSixth int,
    rentFirst double,
    rentSecond double,
    rentThird double,
    rentFourth double,
    rentFifth double,
    rentSixth double,
    expenses double
);


CREATE TABLE IF NOT EXISTS group8
(
    id integer primary key auto_increment,
    workerFirst int,
    workerSecond int,
    workerThird int,
    workerFourth int,
    workerFifth int,
    workerSixth int,
    workerSeventh int,
    workerEighth int,
    rentFirst double,
    rentSecond double,
    rentThird double,
    rentFourth double,
    rentFifth double,
    rentSixth double,
    rentSeventh double,
    rentEighth double,
    expenses double
);