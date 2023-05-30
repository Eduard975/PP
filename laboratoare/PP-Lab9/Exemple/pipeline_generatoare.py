import re


def to_pascal_case(string):
    split_string_generator = (substr for substr in string.split(' '))
    filter_generator = (re.search(r'[a-zA-Z]+', s).group(0)
                        for s in split_string_generator
                        if re.search(r'[a-zA-Z]+', s))
    capitalize_generator = (string.capitalize()
                            for string in filter_generator)
    return ''.join(capitalize_generator)


if __name__ == '__main__':
    string = "This text!@$2.;, should be converted,&*% to pascal case"
    print(to_pascal_case(string))
