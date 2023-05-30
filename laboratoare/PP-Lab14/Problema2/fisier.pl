muta( stare( inmijloc, pecutie, inmijloc, nuarebanana),
iabanana,
stare( inmijloc, pecutie, inmijloc, arebanana) ).
muta( stare( P, pepodea, P, H),
catarapecutie,
stare( P, pecutie, P, H) ).
muta( stare( P1, pepodea, P1, H),
impingeCutia( P1, P2),
stare( P2, pepodea, P2, H) ).
muta( stare( P1, pepodea, B, H),
mergedinP1inP2( P1, P2),
stare( P2, pepodea, B, H) ).
poatelua( Stare1) :-
muta( Stare1, _, Stare2),
poatelua( Stare2),write(Stare1),write(" -> "), write(Stare2),nl.
poatelua( stare( _, _, _, arebanana) ):-
write("Am luat banana"),nl.