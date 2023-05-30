class str(str):
    def toPascalCase(self):
        words = list(self.split(" "))

        return "".join(map(lambda w: w.capitalize(), words))


print(str("2 10 2 10 proba").toPascalCase())