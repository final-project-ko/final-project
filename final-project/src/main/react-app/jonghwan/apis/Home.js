import {Button, View} from "react-native";
import Video from "react-native-video";
import React from "react";

function Home(props) {
    const [isPlaying, setIsPlaying] = React.useState(false);
    const [isMuted, setIsMuted] = React.useState(false);

    const togglePlaying = () => {};

    return (
        <View>
            <Video
                source={video}
                paused={!isPlaying}
                controls={true}
                style={styles.backgroundVideo}
                muted={isMuted}
            />
            <Button
                onPress={() => setIsPlaying(p => !p)}
                title={isPlaying ? 'Stop' : 'Play'}
            />
            <Button
                onPress={() => setIsMuted(m => !m)}
                title={isMuted ? 'Unmute' : 'Mute'}
            />
        </View>
    );
}

export default Home;