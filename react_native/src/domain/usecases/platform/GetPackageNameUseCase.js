import Constants from '../../../utils/Constants.js'
import { logDebug } from '../../../utils/Logger.js'


const LOG_TAG = Constants.LOG.COMMON_USECASE_LOG

/**
 * [ usecase naming rule. ]
 * usecase's prefix: execute
 * example. executeConnectDeviceUseCase
 */
const GetPackageNameUseCase = () => {

    /**
     * Execute the use case. 
     */
    executeGetPackageNameUseCase = () => {
        logDebug(LOG_TAG, ">>> ### triggered executeGetPackageNameUseCase")
    }
    return { executeGetPackageNameUseCase }
}

/**
 * export bluetooth usecase.
 */
export default GetPackageNameUseCase