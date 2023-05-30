from pyswip import Prolog

if __name__ == '__main__':
    prolog = Prolog()
    prolog.consult('fisier.pl')
    command =  'poatelua(stare(lausa, pepodea, lafereastra, nuarebanana)).'
    
    answer = next(prolog.query(command))
    if(answer):
        print(answer)
   