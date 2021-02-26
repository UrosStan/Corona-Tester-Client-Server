# Korona-Test-Klijent-Server
Evo ga zadataak i zahtevi koji su uradjeni:

Potrebno je napraviti klijent-server aplikaciju kroz koju će korisnik moći da vrši test
samoprocene na korona virus i koja će simulirati testiranje korisnika.
Aplikacija treba da omogući sledeće funkcionalnosti:
 Registraciju korisnika
 Prijavljivanje korisnika na sistem (username i password)
 Test samoprocene korisnika na korona virus kroz set pitanja
 „Testiranje” korisnika na korona virus
 Pregled statistike o broju:
o testiranja
o pozitivnih testova
o negativnih testova
o onih korisnika koji su trenutno pod nadzorom



Osnovni zahtev (60%)
 Korisnik se registruje na sistem za samoprocenu. Registracija obuhvata osnovne
podatke o korisniku kao što su username, password, ime, prezime, pol i email.
 Korisnik se može prijaviti na sistem ukoliko se uspešno registrovao.
 Nakon prijavljivanja korisnika na sistem može se pristupiti testu samoprocene na
korona virus. Test samoprocene obuhvata niz pitanja na osnovu kojih se utvrđuje da
li je potrebno da korisnik uradi brzi test.
 Set pitanja na koja je potrebno da korisnik da odgovor radi samoprocene:
o Da li ste putovali van Srbije u okviru 14 dana pre početka simptoma?
o Da li ste bili u kontaku sa zaraženim osobama?
o Šta imate od simptoma (Da/Ne):
 Povišena temperatura
 Kašalj
 Opšta slabost
 Gubitak čula mirisa
 Gubitak/promena čula ukusa
 Ukoliko je korisnik dao potvrdan odgovor na bar dva pitanja potrebno je pristupiti
brzom testu.
 Rezultat brzog testa treba da bude nasumično odabran (pozitivan ili negativan
rezultat).
 Nakon testiranja brzim testom korisniku sistem odmah javlja rezultate (odmah mu se
prikazuju).
 Potrebno je voditi evidenciju o rezultatima testa samoprocene i rezultatima brzog
testa tako da ulogovan korisnik može da pregleda datum kada je radio test i rezultat.
 Ukoliko nema potrebe za testiranjem, korisnik se beleži u sistemu kao da je u
statusu praćenja (pod nadzorom) i od njega se zahteva da ponovi test samoprocene
nakon određenog vremena kako bi izašao iz nadzora.
 Obezbediti da u sistemu postoji poseban tip korisnika (administrator) koji može da
vidi statistiku o broju testiranja, pozitivnih testova, negativnih testova, kao i
pacijenata koji su pod nadzorom.
Ograničenja:
 Omogućiti da server može istovremeno raditi sa više klijenata.
 Klijent može prekinuti komunikaciju u bilo kom trenutku.
 Korisnik u jednom danu može uraditi samo jedan test samoprocene i jedan brzi
test.
 Samo korisnik administrator može da vidi statističke podatke.
 Korisnik administrator ne može da se testira i vrši test samoprocene sa svog
administratorskog naloga.
 Obrada grešaka pri mrežnoj komunikaciji i radu programa je obavezna



Dodatni zahtev 1 (20%)
 Nakon testa samoprocene, ukoliko je potrebno da se korisnik testira, umesto da
direktno radi brzi test, korisnik može da odabere da li želi da uradi brzi test, PCR
test ili oba.
 Kod PCR testa korisnik ne dobija odmah rezultate već nakon određenog vremena
(do 5 minuta).
 Korisnik prilikom prijave na sistem može pratiti stanje PCR testa (na čekanju,
poslato, u obradi, gotov) i videti rezultate.
 Kao i kod testa samoprocene i brzog testa, potrebno je voditi evidenciju o
rezultatima PCR testa tako da ulogovan korisnik može da pregleda datum kada je
radio test i rezultat.
 Korisnik takođe, može da vidi i podatke o poslednjoj prijavi na sistem i vremenu
poslednje samoprocene.
Ograničenja:
 Korisnik u jednom danu može uraditi samo jedan PCR test.



Dodatni zahtev 2 (20%)
 Voditi računa o trenutnom stanju korisnika (pozitivan, negativan, pod nadzorom).
 Prilikom prijave na sistem korisnik administrator dobija listu novih pozitivnih i listu
korisnika koji nisu odradili test samoprocene da bi izašli iz nadzora, a prošao je
period u kome je to trebalo da se odradi.
 Korisnik administrator može videti listu svih korisnika i njihovo trenutno stanje.
 Korisnik administrator može videti posebno listu pozitivnih, posebno listu negativnih i
posebno listu korisnika pod nadzorom na upit.
Ograničenja:
 Pozitivan korisnik postaje negativan u slučaju ponovljenog testa koji je negativan.
 Liste korisnika koje se prikazuju administratoru treba da sadrže ime, prezime i email
korisnika.

NAPOMENE:
Potrebno je da klijentska aplikacija sadrži korisnički interfejs. Nije neophodno da interfejs
bude grafički, moguće je napraviti i konzolnu aplikaciju. Serverska i klijentska aplikacija su
dva odvojena projekta. Svi projekti moraju biti razvijeni na takav način da budu otporni
na greške u radu i komunikaciji (potrebno je implementirati alternativne slučajeve
korišćenja).
