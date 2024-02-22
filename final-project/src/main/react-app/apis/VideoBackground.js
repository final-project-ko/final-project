import Video from "react-native-video";
import {StyleSheet} from "react-native";


export const VideoBackground = () => {
    return (
        <Video
            source={require("../assets/139519 (720p) (1).mp4")}
            style={styles.backgroundVideo}
            muted={true}
            repeat={true}
            resizeMode={"cover"}
            rate={1.0}
            ignoreSilentSwitch={"obey"}
        />

    );
};

const styles = StyleSheet.create({
    background:{
        position: 'absolute',
        top:0,
        left:0,
        bottom:0,
        right:0
    },
});