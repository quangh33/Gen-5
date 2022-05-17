import functools
from queue import PriorityQueue
from typing import List

@functools.total_ordering
class PQItem(object):
    '''
        Custom Priority Queue Item.
        Used for implementing Max PQ
    '''
    def __init__(self, heat: int, word) -> None:
        self.heat = heat
        self.word = word

    def __eq__(self, other):
        return (self.heat, self.word) == (other.heat, other.word)

    def __lt__(self, other):
        if self.heat > other.heat:
            return True
        if self.heat < other.heat:
            return False
        return self.word < other.word
    
    def __gt__(self, other):
        if self.heat < other.heat:
            return True
        if self.heat > other.heat:
            return False
        return self.word < other.word
    
    def __repr__(self) -> str:
        return f'{self.heat}-{self.word}'

# print(PQItem(1,'a') == PQItem(1,'a'))
# print(PQItem(1,'a') > PQItem(2,'a'))
# print(PQItem(1,'b') > PQItem(2,'a'))
# print(PQItem(3,'a') < PQItem(3, 'b'))
# print(PQItem(3,'i love leetcode') < PQItem(3, 'iroman'))
# print(PQItem(3,'iaea') < PQItem(3, 'iroman'))

class TrieNode:
    def __init__(self) -> None:
        self.letters = [None] * 27
        self.topHeats = PriorityQueue() # this is a Min Queue

    def addHeat(self, targetWord: str, extraHeat = 1):
        baseHeat = 0
        for idx, item in enumerate(self.topHeats.queue):
            heat, word = item.heat, item.word
            if word == targetWord:
                self.topHeats.queue.pop(idx)
                baseHeat = heat
                break
        newHeat = baseHeat + extraHeat
        self.topHeats.put(PQItem(newHeat, targetWord))
    
    def top3(self) -> List[str]:
        # right here I did try to get top three from priority queue,
        # but the result is sometime unpredictable, I don't know the root cause.
        # When I run debug, it return expected result, but it won't when i exec code.
        # so i end up in sort the array and return top 3.
        # Priority Queue in python is build on top of a array,
        # so I can sort the underlying array and take top 3.
        result = []
        self.topHeats.queue.sort()
        for item in self.topHeats.queue[:3]:
            result.append(item.word)
        return result

def getCharIdx(c: str) -> int:
    index = ord(c) - 97
    if c == ' ':
        index = 26
    return index

class AutocompleteSystem:
    def __init__(self, sentences: List[str], times: List[int]):
        self.currNode = self.root = TrieNode()
        self.length = len(sentences)
        for i in range(self.length):
            self.insert(sentences[i], times[i])
        self.searchingStr = ''
        self.top3 = []

    def insert(self, word: str, extraHeat: int) -> None:
        currNode = self.root
        for letter in word:
            index = getCharIdx(letter)
            if currNode.letters[index] == None:
                currNode.letters[index] = TrieNode()
            currNode = currNode.letters[index]
            currNode.addHeat(word, extraHeat)

    def input(self, c: str) -> List[str]:
        if c == '#':
            self.top3 = []
            self.insert(self.searchingStr, 1)
            self.searchingStr = ''
            self.currNode = self.root
            return []
        # c != #
        self.searchingStr += c
        index = getCharIdx(c)
        if self.currNode.letters[index] != None and (len(self.top3) > 0 or len(self.searchingStr) == 1):
            self.currNode = self.currNode.letters[index]
            self.top3 = [*self.currNode.top3()]
        else:
            self.top3 = []
        return self.top3

sentences = ["cc cc ccccc","c c ccccc","cc cccc c c","cc","cc cc","cc c ccccc ccc","ccc c","cc cccc","ccccc cc cccc","ccccc cccc cc","cc ccccc cc cccc","ccc ccccc cccc","cccc cccc ccc","cc ccc","cc c","cccc ccc","ccc","cc cc cc","ccc c ccc cccc","c","ccc cc cc ccc","c cc","cccc","ccccc ccccc","ccc cccc ccccc","cccc ccc c","ccc c ccccc ccccc","ccccc ccc","cccc c","cccc cccc ccccc","cc ccc c ccc","ccccc","cc ccccc","ccc cccc c","c c","ccc ccccc ccccc","ccccc ccccc ccc cccc","ccccc cccc ccccc","ccccc ccccc c","cccc ccccc","ccccc cc","c cc c","ccc cc cc","cccc c cccc","c ccc cc cccc","c ccc","cc cc ccc","ccc ccc","ccccc cccc cc cccc","c ccccc","ccc c cc","cccc cccc cc ccccc","ccccc ccc cc ccc","c ccccc cc ccc","c cccc","c cc ccc ccc"]
times = [4,5,3,4,2,4,3,3,5,1,1,5,5,1,4,3,2,5,3,4,5,2,5,2,3,4,4,3,1,2,2,3,4,2,1,5,5,3,2,3,1,3,3,3,2,3,5,1,2,1,2,5,5,1,4,2]
s = AutocompleteSystem(sentences, times)
tests =[["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],["#"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["#"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["#"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],[" "],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["#"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["#"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["#"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["#"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"],["c"],["c"],[" "],["c"],["c"],["c"],["#"],["c"],["c"],["c"],["c"],["c"],[" "],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["#"],["c"],[" "],["c"],["c"],["c"],["c"],[" "],["c"],["c"],["c"],[" "],["c"],["c"],["c"],["c"],["c"],["#"]]
print(len(sentences))
print(len(times))
print(len(tests))
for index, test in enumerate(tests):
    target = 148
    if index == target:
        a = 1
        
    out = s.input(test[0])
    if index == target:
        print('test case: ', index)
        print('input: ', test[0])
        print('output: ', out)
        str = '['
        for item in s.currNode.topHeats.queue:
            str += f"({item.heat}, '{item.word}'),"
        str += ']'
        print(str)
        

# sentences, times = ["i love you","island",  "i love leetcode", "iaea","iroman"], [5, 3, 2, 2, 2]
# s = AutocompleteSystem(sentences, times)
# print(s.input('i'))
# print(s.input(' '))
# print(s.input('a'))
# print(s.input('#'))
# print(s.input('i'))
# print(s.input(' '))
# print(s.input('a'))
# print(s.input('#'))
# print(s.input('i'))
# print(s.input(' '))
# print(s.input('a'))
# print(s.input('#'))

# sentences = ["uqpewwnxyqxxlhiptuzevjxbwedbaozz","ewftoujyxdgjtazppyztom","pvyqceqrdrxottnukgbdfcr","qtdkgdbcyozhllfycfjhdsdnuhycqcofaojknuqqnozltrjcabyxrdqwrxvqrztkcxpenbbtnnnkfhmebj","jwfbusbwahyugiaiazysqbxkwgcawpniptbtmhqyrlxdwxxwhtumglihrgizrczv","cfptjitfzdcrhw","aitqgitjgrcbacgnaasvbouqsqcwbyskkpsnigtfeecmlkcjbgduban","utsqkmiqqgglufourfdpgdmrkbippffacwvtkpflzrvdlkdxykfpkoqcb","ethtbdopotpamvrwuomlpahtveyw","jiaqkaxovsqtkpdjfbkajpvpyetuoqwnrnpjdhoojbsdvneecsdvgqpyurmsvcy","j","btbnuplyeuccjbernsfbnveillrwdbqledwvpmvdbcugkurrkabtpykhlcogeszclyfuquafouv","hndjzblegevtfkgbjttektox","gtvnlninpvenapyfgmsjdisfnmiktitrutctawosjflvzfkbegnprixzqwzcyhoovsivuwmofsveqkyosowuyamuvy","sawrirvrfrbfagreahrioaombukmdwztbpggnxd","mgdcwptvbvhzyvvumvbjjn","otjvvkegwleyyxtghwgfmlsqlhrlibdvqfinyyebotjpwoaejhtornfgikmifdmwswbqgwhcbzuhrpajxuqicegcptszct","zlondsttyvnnnnxjtoqnlktitwzurissczzbyfsbgpoawodwjpsmavaugnhqtsbeixwl","yehvdehbtmwqkmcjmvpivfzqvevkotwzvjoyfvp","bjximtpayjdcxbrnksbtfnpynzaygygdflowewprqngdadzdhxcpgapjejojrkzrutgcsfpfvpluagniqimfqddldxqiw","bysyrxfykivyauysytgxfhqcrxliulahuizjvozpywrokxujhzpauxwufcxiitukljiiclatfrspqcljjoxpxziumstnhqr","uxtvutlgqapyfltiulwrplesmtowzoyhhjhzihatpuvmutxqgxfawpwypedbz","jzgsdjdawrqfladolduldhpdpagmvllvzamypuqlrpbmhxxadqaqrqavtxeghcyysjynovkiyjtvdluttodtmtocajgttmv","mbijfkmepalhdiubposdksdmmttxblkodcdrxbnxaqebnwliatnxpwaohbwkidia","ljggggbyxwrwanhjonoramexdmgjigrtpz","cqfvkutpipxjepfgsufonvjtotwfxyn","kvseesjazssavispavchdpzvdhibptowhyrrshyntpwkez","nveuzbaosuayteiozmnelxlwkrrrjlwvhejxhupvchfwmvnqukphgoacnazuoimcliubvhv","uwrpwhfdrxfnarxqpkhrylkwiuhzubjfk","bniyggdcloefwy","ihranmhbsahqjxesbtmdkjfsupzdzjvdfovgbtwhqfjdddwhdvrnlyscvqlnqpzegnvvzyymrajvso","lscreasfuxpdxsiinymuzybjexkpfjiplevqcjxlm","uwgnfozopsygnmptdtmmuumahoungpkodwxrcvfymqpeymaqruayvqqgoddgbnhemtsjifhxwiehncswxzrghf","nyfbxgcpfrzyqwfjzgmhuohjhrjizsyjqgmertmooeiaadcmiuyyylpcosnweoyydeauazhzbeaqn","tpylrxbwnkrfxckfdlvrbytaezuzmyscpvruthuvbxjenkeolvqsrjqzizyclzmqtjvnamdansmzyspcfghfprorqprua","nhldlmxpuckxeekipkrzugatjiivtazjbjyxokksyueyjbgmrovbckbxqcqefaiavzsarbbypgmpxe","sylraqsd","xr","xkzpxkhrucyatpatkigvntohihibyisyqtkjdhatdvyvxbjttz","nvnz","blzddwxphkgqfsfzfclwytstpvpzgcdeggdwzukzirscfzcteeuqbmmrfxcnokbbyxkqrxtjfarcefiynwfmy","inuxmuhtdwpuvyludwtokhtalxbuccepsayrjycbcwbtnfholjvkmypodv","awwillrm","xznodxngrstjrwqzmlmigpw","khlxjdtictufdfbkgfusdtaaeuspbbfmtjodflgqofzlqnulkdztflm","nlngmckslyqzjiyiexbropbxnynjcstziluewypboqhqndqsxhtnosrgrameajovsclrgwqjgnztvxrkhwnxkfrf","yroadxhxyacaexrwju","ujxlbpcbxdqrvubifnpzjmmkolyljzjhdegaiowaal","tnfnjgtxbckbpyplucprxcqzhrfjimylmlhdglntfydepltjvklyxesndzuubienhvuaqc","ouedhtkpkg","ygchsrrubucqffewifsxaefwocfaiiupqbomktvrcddggqfgnaycstpccwtbheyaqwhosxajqeqqxzyjsfng","jqqgpjvfkgjh","csowoazaiyejgyixszqmtctpzlkccccqregyhtvxccvrpkupwcyhqatxscevzdfbdqnuyadiyfnhysddfyxpgqtjiogmxsmzbbkr","dlzxdpchkdaztkqtrjmuujgoiae","plcjkwukkyqluxjbhxsyeaqvviinfuujsafwsquidvmutsrukxwrv","yopqbtpoqhpcktjangauzcvvpephhprpaaclbbkgchlqkrwdsaupeizlwxzcpkchoagmrrkwdkthosmrjefgbumnrjsb"]
# times = [12,9,4,4,1,5,3,4,7,9,2,4,2,3,11,13,1,3,4,10,7,1,9,5,10,14,5,3,2,11,5,14,4,13,11,5,15,8,1,12,2,11,4,2,11,14,9,12,1,7,13,11,7,2,6,10]
# s = AutocompleteSystem(sentences, times)
# first = ["bniyggdcloefwy","bjximtpayjdcxbrnksbtfnpynzaygygdflowewprqngdadzdhxcpgapjejojrkzrutgcsfpfvpluagniqimfqddldxqiw","bysyrxfykivyauysytgxfhqcrxliulahuizjvozpywrokxujhzpauxwufcxiitukljiiclatfrspqcljjoxpxziumstnhqr"]
# print(s.input('b') == first)
# print(s.input('k') == [])
# print(s.input('j') == [])
# print(s.input('o') == [])
# print(s.input('#') == [])
# # "r"],["d"],["w"],["h"],["i"],["a"],["g"],["p"],["x"],["m"],["k"],["r"],["q"],["l"],["v"],["l"],["c"],["v"],["w"],["e"],["p"],["d"],["i"],["x"],["j"],["h"],["k"],["v"],["a"],["y"],["m"],["j"],["j"],["r"],["n"],["f"],["h"],["r"],["g"],["o"],["m"],["s"],["d"],["d"],["h"],["x"],["g"],["s"],["k"],["l"],["f"],["m"],["s"],["x"],["t"],["i"],["n"],["s"],["i"],["m"],["w"],["c"],["f"],["f"],["f"],["c"],["f"],["h"],["j"],["m"],["r"],
# print('------------------')
# print(s.input('h') == ['hndjzblegevtfkgbjttektox'])
# print(s.input('e') == [])

# print(s.input('#') == [])
# print('------------------')

# first = ["khlxjdtictufdfbkgfusdtaaeuspbbfmtjodflgqofzlqnulkdztflm","kvseesjazssavispavchdpzvdhibptowhyrrshyntpwkez"]
# print(s.input('k') == first)
# print(s.input('n') == [])
# print(s.input('u') == [])

# print(s.input('#') == [])
# print('------------------')
# print(s.input('w') == [])
# print(s.input('o') == [])
# print(s.input('m') == [])
# print(s.input('p') == [])
# print(s.input('k') == [])
# print(s.input('q') == [])
# print(s.input('g') == [])
# print(s.input('i') == [])
# print(s.input('s') == [])
# print(s.input('a') == [])
# print(s.input('v') == [])
# print(s.input('#') == [])
# print('------------------')
