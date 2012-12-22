from com.orbit.core import EntityScript

class Entity(EntityScript):
    
    def __init__(self):
        self.data = {}

    def onInteract(self):
        self.data['appendMessage'] = 'First message!'
        self.data['destroy'] = 'TRUE'
        return self.data
