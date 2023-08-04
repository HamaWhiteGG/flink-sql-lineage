import React,{useState, useEffect} from 'react'
import { message } from 'antd'
import io from '@common/io-context'
import Monaco from 'react-monaco-editor'
import "monaco-editor/esm/vs/basic-languages/sql/sql.contribution"
import { Base64 } from 'js-base64'

const Cm = (props) => {
  const {catalogId, tableName, databaseName} = props
  const [value, setValue] = useState('')
  const _initOptions = {
    readOnly: true,
    selectOnLineNumbers: true,
    renderSideBySide: false,
    lineNumbersMinChars: 3, // 最少显示3位长的行号
    lineDecorationsWidth: 20,
    quickSuggestions: true,
    renderLineDecorations: (lineNumber, decorations) => {
      return [
        {
          range: { startLineNumber: lineNumber, endLineNumber: lineNumber },
          options: {
            isWholeLine: true,
            linesDecorationsClassName: "line-decoration",
            overviewRulerLane: monaco.editor.OverviewRulerLane.Left
          }
        }
      ]
    }
  }
  const getTableInfos = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/tables/${tableName}/ddl`)
      setValue(Base64.decode(res))
    } catch (error) {
      message.error(error)
    }
  }
  useEffect(() => {
    getTableInfos()
  }, [tableName])
  return (
    <div className='right-info-box pt8'>
      <Monaco 
        height={520}
        // width={620}
        value={value}
        language="sql"
        options={_initOptions}
      />
    </div>
  )
}
export default Cm