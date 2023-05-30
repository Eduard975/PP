from os.path import *


class AudioFile:
    def __init__(self, filename):
        if not filename.endswith(self.ext):
            raise Exception("Format nesuportat")
        self.filename = filename


class MP3File(AudioFile):
    ext = "mp3"

    def play(self):
        print("se canta {} un mp3".format(self.filename))


class WavFile(AudioFile):
    ext = "wav"

    def play(self):
        print("se canta {} un wav".format(self.filename))


class OggFile(AudioFile):
    ext = "ogg"

    def play(self):
        print("se canta {} un ogg".format(self.filename))


class FlacFile:
    def __init__(self, filename):
        if not filename.endswith(".flac"):
            raise Exception("Format necunoscut")
        self.filename = filename


def play(self):
    print("se canta {} un flac".format(self.filename))


if __name__ == '__main__':
    file_path = input('file path = ')
    file_exists = exists(file_path)

    if (file_exists):
        file_path = file_path.split("/")
        my_file = file_path[len(file_path)-1]
        print(my_file)
        temp = my_file
        music_ext = my_file.split(".")
        music_ext = music_ext[len(music_ext)-1]
        match music_ext:
            case "mp3":
                music = MP3File(temp)
                music.play()
