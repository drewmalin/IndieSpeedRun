from com.orbit.core import EntityScript
import Level3

class Entity(EntityScript):
    
    def __init__(self):
        self.data = {}

    def onInteract(self):
        #self.data['appendMessage'] = 'Lamp 2!'
        self.data['destroy'] = 'FALSE'
        #self.data['createOther'] = ['res/entities/3/Lamp3_1.xml']

        return self.data
