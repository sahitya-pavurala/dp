def compute():

    if len(a) != len(b):
        return 0

    word = b + b
    i = 0
    while i  < len(a):
        if word[i:i+len(a)] == a:
            return 1
        i += 1

    return 0



if __name__ == "__main__":
    a = 'amazon'
    b = 'namazo'
    print compute()