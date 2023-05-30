tatal(ilie,vasale).
tatal(popa,vasale).
tatal(george,ilie).
tatal(maria,ilie).
tatal(petru,popa).
tatal(vasilica,cobelea).
tatal(dana,pavel).

mama(george,vasilica).
mama(maria,vasilica).
mama(vasilica,diana).
mama(petru,dana).
mama(matcu,dana).
mama(dana,elena).
mama(ilie,elena).
mama(popa,elena).

barbat(george).
barbat(petru).
barbat(ilie).
barbat(popa).
barbat(vasale).
barbat(cobelea).
barbat(pavel).

femeie(maria).
femeie(matcu).
femeie(vasilica).
femeie(ileana).
femeie(dana).
femeie(diana).
femeie(elena).

sot(vasilica,ilie).
sot(dana,popa).
sot(ileana,petru).

unchi(george,popa).
unchi(petru,ilie).

frate(X,Y) :- tatal(X,A),tatal(Y,A),barbat(X),barbat(Y).
% frate(X,Y) :- frate(Y,X),barbat(X),barbat(Y).
sora(X,Y) :- tatal(X,A),tatal(Y,A),femeie(Y).
matusa(X,Y) :- sot(Y,Z),frate(Z,W), Z \= W, tatal(X,W).
bunicul(X,Y) :-
barbat(Y),
tatal(X,W),
tatal(W,Y).

bunicul(X,Y) :-
barbat(Y),
mama(X,W),
tatal(W,Y).

bunica(X,Y) :-
femeie(Y),
tatal(X,W),
mama(W,Y).

bunica(X,Y) :-
femeie(Y),
mama(X,W),
mama(W,Y).