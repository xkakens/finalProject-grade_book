-----OPIS PROJEKTU-----

Autorzy: Bartosz Boćkowski, Michał Szyba

Nasz projekt końcowy będzie dziennikiem w formie online, tzw. e-dziennik. Zamierzamy umieścic w nim wiele praktycznych funkcjonalności, które stanowią
znaczną część funkcji e-dzienników oferowanych szkołom przez dostawców takich usług. Może nam w tym pomóc nasze doświadczenie z takimi systemami, które
zdobyliśmy korzystając z nich latami w trakcie naszej edukacji. Zamierzamy uprościc naszą stronę, co oznacza zmniejszenie liczby widoków, na przykład poprzez
wprowadzenie możliwości zmiany wielu rodzajów danych w jednym widoku.

-----PODZIAŁ PRACY-----

Bartek: schemat widoków i funkcjonalności

Bartek: projektowanie tabel

Wspólnie: konfiguracja projektu ze springiem i hibernatem

Michał: utworzenie klas, interfejsów i kontrolerów

Michał: utworzenie encji/tabel

-----TABELE MYSQL(jeszcze niezrobione)-----

- kategorie ocen(id, nazwa)
- plan lekcji:
	id klasy
	id grupy (0-cala klasa,1-1 grupa, 2-2 grupa)
	plec do wfu (0-cala klasa, 1-chlopaki, 2-dziewczyny)
	id godziny (0 to 1 godzina, 2 to druga i tak dalej)
	id sali
	id nauczyciela
-sale(id sali, numer sali)
-tabelka z godzinami lekcji i przerw:
	id(nieparzyste id to przerwa, parzyste to lekcja)
	godzina rozpoczecia
-przedmiotyKlasy(id klasy, id przedmiotu, id nauczyciela)
-user(id, email, haslo, typ(uczen, nauczyciel, dyrektor, rodzic))

huj