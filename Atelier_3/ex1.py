def full_name(str_arg:str)->str:
    """fonction qui retourne le nom en majuscule et le prenom avec la première lettre ne majuscule.

    Args:
        str_arg (str): chaine de caractères 

    Returns:
        str: chaine de caractères 
    """

    res = ''

    str_separe = str_arg.split()
    nom = str_separe[0].upper()
    prenom = str_separe[1].title()
    res = nom + ' '+ prenom
    return res

def is_mail(str_arg:str)->(int,int):
    """fonction qui teste si une adresse mail est valide

    Args:
        str_arg (str): chaine de caractères 

    Returns:
        tuple: code d'erreur
    """
    a = 0
    b = 0

    if '@' in str_arg:

        corps, domaine = str_arg.split('@')
        if corps == '' or corps[0] == '.' or corps[-1] == '.' or '..' in corps:
            b = 1
        elif domaine == '' or domaine[0] == '.' or domaine[-1] == '.' or '..' in domaine:
            b = 3
        elif '.' not in domaine:
            b = 4
        else:
            a = 1
    else:
       b = 2

    return (a,b)

print(full_name("mirande clementine"))
print(is_mail("@univ-corse.fr"))