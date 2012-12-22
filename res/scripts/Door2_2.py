from com.orbit.core import EntityScript

class Entity(EntityScript):
    
    def __init__(self):
        self.data = {}

    def onInteract(self):
        self.data['level'] = 'Level3.xml'
        return self.data
