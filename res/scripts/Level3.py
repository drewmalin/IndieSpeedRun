progress = [False, False, False]

def update(entID):
    global progress
    tempProgress = True
    progress[entID] = True

    for val in progress:
        if val == False:
            tempProgress = False

    return tempProgress
