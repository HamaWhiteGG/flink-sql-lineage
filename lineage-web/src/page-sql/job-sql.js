import React,{ useState, useEffect } from 'react'
import { useParams, useOutletContext } from 'react-router-dom'
import { Breadcrumb, Tooltip, message, Badge } from 'antd'
import { SaveOutlined, FormatPainterOutlined, ExpandOutlined, BranchesOutlined } from '@ant-design/icons';
import Monaco from 'react-monaco-editor'
import "monaco-editor/esm/vs/basic-languages/sql/sql.contribution"
import axios from 'axios'
import { Base64 } from 'js-base64'

const Cm = (props) => {
  // const {taskId, taskName, taskSource, database, catalogId} = data
  const { id:taskId } = useParams()
  const [taskDetail, setTaskDetail] = useState({})
  const [lineageGraph, setLineageGraph] = useState({'nodes': [], 'links': []})
  const [isUpdate, setIsUpdate] = useState(false)
  const { analysisSql } = useOutletContext()
  let obj = {
    'FAILED': 'error', 
    'INIT': 'default', 
    'MODIFIED': 'warning', 
    'RUNNING': 'processing', 
    'SUCCESS': 'success'
  }

  const _initOptions = {
    selectOnLineNumbers: true,
    renderSideBySide: false,
    lineNumbersMinChars: 3, // 最少显示3位长的行号
    lineDecorationsWidth: 20,
    quickSuggestions: true,
    minimap: {
      enabled: false,
    },
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
  const [value, setValue] = useState(null)
  const editorWillMount = (editor, monaco) => {
    // editor.getAction('editor.action.formatDocument').run();
    // var decorations = monaco.editor.deltaDecorations(
      // [],
    //   [
    //     {
    //       range: new monaco.Range(3, 1, 5, 1),
    //       options: {
    //         isWholeLine: true,
    //         linesDecorationsClassName: "myLineDecoration",
    //       },
    //     },
    //     {
    //       range: new monaco.Range(7, 1, 7, 24),
    //       options: { inlineClassName: "myInlineDecoration" },
    //     },
    //   ]
    // );
  
    // monaco.editor.IModelDecorationOptions = {
    //   // firstLineDecorationClassName: "myInlineDecoration",
    //   inlineClassName: "myInlineDecoration",
    //   className: "myLineDecoration",
    //   zIndex: 5,
    //   after: {
    //     linesDecorationsClassName: "myInlineDecoration",
    //   },
    //   stickiness: {
    //     AlwaysGrowsWhenTypingAtEdges: 0
    //   }
    // }
  }
  
  // update sql
  const updateSql = async () => {
    try {
      const res = await axios.put(`/tasks/${taskId}`, {
        source: Base64.encode(value),
        taskId,
      })
      const {data, message: msg} = res?.data
      if (data) message.success(msg)
    } catch (e) {
      message.error(e)
    }
  }

  // const analysisSql = async () => {
  //   await updateSql()
  //   axios.post(`/tasks/${taskId}/lineage`)
  // }

  const getJobDetail = async (taskId) => {
    try {
      const res = await axios.get(`tasks/${taskId}`)
      // console.log('res.data.data---', res.data.data)
      setLineageGraph(res.data.data.lineageGraph)
      setTaskDetail(res.data.data)
      setValue(Base64.decode(res?.data?.data?.taskSource))
    } catch (e) {
      
    } finally {
    }
  }

  // change monaco
  const onChangeMonaco = (val) => {
    if (value !== val ) {
      setValue(val)
      setIsUpdate(true)
    } else {
      setIsUpdate(false)
    }
  }

  const onKeyDown = (e) => {
    if (e.ctrlKey && e.keyCode == 83 || e.metaKey && e.keyCode == 83) {
      e.preventDefault();
      updateSql()
    }
  }

  useEffect(() => {
    getJobDetail(taskId)
  }, [taskId])

  useEffect(() => {
    document.addEventListener("keydown", onKeyDown)
  }, [])

  return (
    <div className='left-box'>
      <div className="FBH FBJ p16">
        <Breadcrumb separator="<">
          <Breadcrumb.Item href="#/job/list">Job</Breadcrumb.Item>
          <Breadcrumb.Item>{taskDetail?.taskName || '--'}</Breadcrumb.Item>
        </Breadcrumb>
       
        <Tooltip title={taskDetail?.taskStatus}><Badge status={obj[taskDetail?.taskStatus]} className='hand' /></Tooltip>
      </div>
      <div>
        <div className='FBH FBJ pl16 pr16 pt8 pb8 gray-box-deep'>
          <div>
            <Tooltip title='analysis'>
              <BranchesOutlined className='mr24 hand' 
                onClick={async () => {
                  if (isUpdate) {
                    await updateSql()
                  }
                  analysisSql()
                  setIsUpdate(false)
                }}
              />
            </Tooltip>
            <Tooltip title='save'>
              <SaveOutlined className='mr24 hand' onClick={() => updateSql()} />
            </Tooltip>
            <Tooltip title='format code'>
              <FormatPainterOutlined className='mr24 hand' />
            </Tooltip>
            <Tooltip title='scrren all'>
              <ExpandOutlined className='mr24 hand' />
            </Tooltip>
          </div>
        </div>
        <Monaco 
          height={700}
          width={580}
          value={value}
          language="sql"
          options={_initOptions}
          editorWillMount={editorWillMount}
          onChange={onChangeMonaco}
        />
      </div>
    </div>
  )
}

export default Cm