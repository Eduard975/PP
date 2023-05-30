import more_itertools

def cuvinte():
    text = 'Aceasta propozitie are multe cuvinte care incep cu litere diferite'

    result = more_itertools.map_reduce(text.split(), lambda x: x[0], reducefunc = lambda text: sorted(text))
    new_result = sorted(result.values())
    
    result_as_string = ' '.join(' '.join(elem) for elem in new_result)

    print(f'\n\nRezultat lista: {new_result}')
    print(f'\nRezultat ca string: {result_as_string}\n')

if __name__ == "__main__":
    cuvinte()