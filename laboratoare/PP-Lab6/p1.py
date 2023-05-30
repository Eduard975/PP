class ContactList(list):
    def search(self, name):
        matching_contacts = []
        for contact in self:
            if name in contact.name:
                matching_contacts.append(contact)
        return matching_contacts


class Contact:
    def __init__(self, name, email):  # constructor
        self.name = name
        self.email = email
#    echivalentul supraincarcarii operator<< din c++

    def __repr__(self):
        return "Contact({}, {})".format(self.name, self.email)


class Agenda:
    all_contacts = ContactList()

    def add_contact(self, contact):
        self.all_contacts.append(contact)

    def print_agenda(self):
        for contact in self.all_contacts:
            print(contact)


class Friend(Contact):
    def __init__(self, name, email, phone):
        super().__init__(name, email)
        self.phone = phone

    def __repr__(self):
        return "Contact({}, {}, {})".format(self.name, self.email, self.phone)


def meniu():
    print("Alegeti optiunea dorita: \n(1)Adauga Contact\n(2)Adauga Prieten\n(3)Afisare Lista Contacte\n(0)Inchide Meniu")
    agenda = Agenda()
    option = int(input())
    name = ""
    mail = ""
    number = ""
    match option:
        case 1:
            name = input("\nIntroduceti nume contact:")
            mail = input("Introduceti mail contact:")
            agenda.add_contact(Contact(name, mail))
            print("\n")

            return option
        case 2:
            name = input("\nIntroduceti nume prieten:")
            mail = input("Introduceti mail prieten:")
            number = input("Introduceti numar prieten:")
            agenda.add_contact(
                Friend(name, mail, number))
            print("\n")

            return option
        case 3:
            print("\nLista Contacte:")
            agenda.print_agenda()
            print("\n")
            return option
        case 0:
            return option

    # acest bloc se executa doar cand se apeleaza acest script
    # se recomanda folosirea acestui bloc pentru a nu se executa la import
if __name__ == '__main__':
    while (1):
        option = meniu()
        if (option == 0):
            break
