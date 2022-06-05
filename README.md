# University-resources

Am implementat proiectul numarul 4, anume University Resources. 

In urmatoarele randuri, voi explica putin abordarea acestuia:
- aplicatia realizata de mine are 2 versiuni: "Version1App" si "Version2App";
- este construita pe 3 JFrame-uri, avand o interfata placuta si bine construita;
- la deschiderea acesteia, se alege din meniu versiunea dorita, utilizatorului deschizandu-se JFrame-ul corespunzator;
- prezinta o conexiune cu 2 baza de date "MySQL", cate una pentru fiecare versiune a aplicatiei.

Version1App:
* primeste ca input un numar de sali si capacitatea fiecareia;
* are un orar predefinit stocat intr-o baza de date;
* asigneaza sali in modul cel mai eficient posibil ( => in cat mai putine sali folosite posibile);
* returneaza orarul astfel obtinut in aplicatie.

Version2App:
* primeste ca input: un profesor, o materie, daca este curs sau nu, o serie si o sala;
* se pot da cate astfel de input-uri dorim;
* aplicatia creeaza un orar, intr-un mod arbitrat, respectand toate constrangerile: acelasi profesor nu poate avea ora in 2 locuri diferite, aceeasi grupa nu poate avea 2 ore in acelasi timp, s.a.m.d.;
* returneaza orarul astfel obtinut atat in aplicatie, cat si intr-un tabel dintr-o baza de date.
