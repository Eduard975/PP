from pyswip import Prolog

if __name__ == '__main__':
    prolog = Prolog()
    prolog.consult('fisier.pl')

    print('----------- P1.1 -----------')
    print('Perechi care au o matusa: ')
    
    for human in prolog.query('matusa(X, Y)'):
        print(f'{human["Y"]} este matusa a lui {human["X"]}')
        
    print('\n')

    print('----------- P1.2 -----------')
    print('Perechi care au un bunic:')
    for human in prolog.query('bunicul(X, Y)'):
        print(f'{human["Y"]} este bunicul lui {human["X"]}')
    print('\n')

    print('----------- P1.3 -----------')
    print('Sora lui George: ')
    for human in prolog.query('sora(george, Y)'):
        print(f'{human["Y"]} este o sora a lui george')